package edu.school21.app;

import edu.school21.logic.Logic;

public class MapCreator {

    private Coordinates getRandom(){
        int x, y;
        do
            x = (int)(Math.random() * mapSize);
        while (x == mapSize);
        do
            y = (int)(Math.random() * mapSize);
        while (y == mapSize);
        return new Coordinates(x, y);
    }

    public GameMap generateMap() throws IllegalParametersException{
        Coordinates coordinates;
        int path;
        int maxPath = mapSize * mapSize - wallsCount - enemiesCount - 1;
        if (maxPath < 1)
            throw new IllegalParametersException();

        GameMap gameMap = GameMap.getInstance();
        gameMap.setMapSize(mapSize);
        gameMap.setMaxPath(maxPath);

        coordinates = getRandom();
        gameMap.setGoal(new Goal(coordinates));

        do {
            coordinates = getRandom();
            path = Logic.pathForPlayer(coordinates);
        }
        while (gameMap.isObjectHere(coordinates) || path > maxPath);
        gameMap.setPlayer(new Player(coordinates));


        for (int i = 0; i < wallsCount; i++){
            do {
                do {
                    coordinates = getRandom();
                }
                while (gameMap.isObjectHere(coordinates));
                gameMap.walls.add(coordinates);
                path = Logic.pathForPlayer(gameMap.getPlayer().coordinates);
                gameMap.walls.deleteWall(coordinates);
            }
            while (path > maxPath);
            gameMap.walls.add(coordinates);
        }

        for (int i = 0; i < enemiesCount; i++){
            do {
                do {
                    coordinates = getRandom();
                }
                while (gameMap.isObjectHere(coordinates));
                gameMap.enemies.add(coordinates);
                path = Logic.pathForPlayer(gameMap.getPlayer().coordinates);
                gameMap.enemies.deleteEnemy(coordinates);
            }
            while (path > maxPath);
            gameMap.enemies.add(coordinates);
        }

        return gameMap;
    }

    public static MapCreator getInstance(int enemiesCount, int wallsCount, int mapSize){

        MapCreator mapCreator = instance;
        instance.setParameters(enemiesCount, wallsCount, mapSize);
        return instance;
    }

    public final MapConfig mapConfig = MapConfig.getInstance();

    private int enemiesCount;
    private int wallsCount;
    private int mapSize;

    private static final MapCreator instance = new MapCreator();

    private MapCreator(){}

    private MapCreator(int enemiesCount, int wallsCount, int mapSize){
        this.enemiesCount = enemiesCount;
        this.wallsCount = wallsCount;
        this.mapSize = mapSize;
    }
    private void setParameters(int enemiesCount, int wallsCount, int mapSize){
        this.enemiesCount = enemiesCount;
        this.wallsCount = wallsCount;
        this.mapSize = mapSize;
    }
}
