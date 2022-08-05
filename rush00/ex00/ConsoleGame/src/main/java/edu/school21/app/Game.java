package edu.school21.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.Parameter;
import edu.school21.logic.Logic;

import static java.lang.Thread.sleep;


@Parameters(separators = "=")
public class Game {
        @Parameter(names = {"--enemiesCount"})
        private static int enemiesCount;
        @Parameter(names = {"--wallsCount"})
        private static int wallsCount;
        @Parameter(names = {"--size"})
        private static int mapSize;
        @Parameter(names = {"--profile"})
        private static String profile;
        public static void main(String[] args) throws IllegalParametersException {
                Game main = new Game();
                JCommander.newBuilder()
                        .addObject(main)
                        .build()
                        .parse(args);
                run();
        }

        private static void run() throws IllegalParametersException {
                if (enemiesCount == 0 || wallsCount == 0 || mapSize == 0 || profile.equals(""))
                        throw new IllegalParametersException();

                MapCreator mapCreator = MapCreator.getInstance(enemiesCount, wallsCount, mapSize);
                InputStream fileProperties = Game.class.getResourceAsStream(
                        "/application-" + profile + ".properties");
                if (fileProperties == null)
                        throw new IllegalParametersException();
                Properties properties = new Properties();
                try {
                        properties.load(fileProperties);
                }
                catch (IOException ex){
                        throw new RuntimeException(ex);
                }
                mapCreator.mapConfig.loadConfig(properties);
                GameMap gameMap = mapCreator.generateMap();
                gameMap.redrawMap();
//                System.out.println(Logic.pathForPlayer(gameMap.getPlayer().coordinates));
                Scanner sc = new Scanner(System.in);
                do {
                        String command = sc.nextLine();
                        switch (command) {
                                case "a":
                                        if (!Logic.checkPosition(gameMap.getPlayer().coordinates.left())) {
                                                System.out.println("You can't go there!");
                                                continue;
                                        } else
                                                gameMap.getPlayer().moveLeft();
                                        break;
                                case "d":
                                        if (!Logic.checkPosition(gameMap.getPlayer().coordinates.right())) {
                                                System.out.println("You can't go there!");
                                                continue;
                                        } else
                                                gameMap.getPlayer().moveRight();
                                        break;
                                case "w":
                                        if (!Logic.checkPosition(gameMap.getPlayer().coordinates.up())) {
                                                System.out.println("You can't go there!");
                                                continue;
                                        } else
                                                gameMap.getPlayer().moveUp();
                                        break;
                                case "s":
                                        if (!Logic.checkPosition(gameMap.getPlayer().coordinates.down())) {
                                                System.out.println("You can't go there!");
                                                continue;
                                        } else
                                                gameMap.getPlayer().moveDown();
                                        break;
                                default:
                                        System.out.println("Unknown command");
                                        continue;
                        }
                        gameMap.redrawMap();
                        if (gameMap.getPlayer().coordinates.equals(gameMap.getGoal().coordinates))
                                continue;

                        for (Enemy enemy: gameMap.enemies.getEnemies()){
                                Logic.enemyMove(enemy);
                        }
                        try {
                                sleep(1000);
                        }
                        catch (InterruptedException ex){
                                System.out.println(ex.getMessage());
                        }
                        System.out.println();
                        gameMap.redrawMap();
                }
                while (!gameMap.getPlayer().coordinates.equals(gameMap.getGoal().coordinates)
                && !gameMap.enemies.isEnemy(gameMap.getPlayer().coordinates)
                && Logic.hasMove());
                if (gameMap.getPlayer().coordinates.equals(gameMap.getGoal().coordinates))
                        System.out.println("You Win!");
                else
                        System.out.println("You're not win :(");
        }
}
