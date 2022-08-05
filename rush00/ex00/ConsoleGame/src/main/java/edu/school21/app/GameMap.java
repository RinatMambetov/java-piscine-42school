package edu.school21.app;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.*;
import edu.school21.logic.Logic;

public class GameMap {

    public boolean isObjectHere(Coordinates coordinates) {
        if (player != null && player.coordinates.equals(coordinates))
            return true;
        if (goal != null && goal.coordinates.equals(coordinates))
            return true;
        if (enemies.isEnemy(coordinates))
            return true;
        if (walls.isWall(coordinates))
            return true;
        return false;
    }

    public GameObjects getObject(Coordinates coordinates) {
        if (enemies.isEnemy(coordinates))
            return enemies.getEnemy(coordinates);
        if (player != null && player.coordinates.equals(coordinates))
            return player;
        if (goal != null && goal.coordinates.equals(coordinates))
            return goal;
        if (walls.isWall(coordinates))
            return walls.getWall(coordinates);
        return null;
    }

    public void deleteObject(Coordinates coordinates){
        GameObjects gameObjects = getObject(coordinates);
        if (gameObjects != null){
            if (gameObjects.type == ObjectsEnum.ENEMY){
                enemies.deleteEnemy(coordinates);
            }
            if (gameObjects.type == ObjectsEnum.WALL){
                walls.deleteWall(coordinates);
            }
            if (gameObjects.type == ObjectsEnum.GOAL){
                goal = null;
            }
            if (gameObjects.type == ObjectsEnum.PLAYER){
                player = null;
            }
        }
    }

    public void redrawMap(){
        System.out.print("\033[H\033[J");
        for (int y = 0; y < mapSize; y++){
            for (int x = 0; x < mapSize; x++){
                if (isObjectHere(new Coordinates(x, y))){
                    GameObjects obj = getObject(new Coordinates(x, y));
                    switch (obj.type){
                        case ENEMY:
                            cp.print(mapConfig.getEnemyChar(), Attribute.NONE, FColor.BLACK, mapConfig.getEnemyColor());
                            break;
                        case WALL:
                            cp.print(mapConfig.getWallChar(), Attribute.NONE, FColor.BLACK, mapConfig.getWallColor());
                            break;
                        case PLAYER:
                            cp.print(mapConfig.getPlayerChar(), Attribute.NONE, FColor.BLACK, mapConfig.getPlayerColor());
                            break;
                        case GOAL:
                            cp.print(mapConfig.getGoalChar(), Attribute.NONE, FColor.BLACK, mapConfig.getGoalColor());
                    }
                }
                else
                    cp.print(mapConfig.getEmptyChar(), Attribute.NONE, FColor.BLACK, mapConfig.getEmptyColor());
            }
            cp.print("", Attribute.NONE, FColor.NONE, BColor.NONE);
//            cp.println("");
            System.out.println();
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Goal getGoal() {
        return goal;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public final EnemyList enemies = EnemyList.getInstance();
    public final ListWalls walls = ListWalls.getInstance();
    private Player player;
    private Goal goal;

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public static GameMap getInstance() {
        return instance;
    }

    public void setMaxPath(int maxPath) {
        this.maxPath = maxPath;
    }

    public int getMaxPath() {
        return maxPath;
    }

    private static final GameMap instance = new GameMap();

    private GameMap() {
    }

    public void printStatistic(){
        System.out.printf("Path Player: %d\n", Logic.pathForPlayer(player.coordinates));
        int count = 0;
        for (Enemy enemy: enemies.getEnemies()){
            System.out.printf("Path Enemy%d: to goal %d to player: %d\n", count,
                    Logic.pathForComputer(enemy.coordinates, getGoal().coordinates, true),
                    Logic.pathForComputer(enemy.coordinates, getPlayer().coordinates, false)
            );
            count++;
        }
    }

    private final ColoredPrinter cp = new ColoredPrinter.Builder(1, false).build();
    private int mapSize;
    private final MapConfig mapConfig = MapConfig.getInstance();

    int maxPath;

}
