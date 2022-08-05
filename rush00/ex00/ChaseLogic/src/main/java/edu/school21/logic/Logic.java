package edu.school21.logic;

import edu.school21.app.Coordinates;
import edu.school21.app.Enemy;
import edu.school21.app.ObjectsEnum;
import edu.school21.app.GameMap;

import java.util.*;

public class Logic {

    public static boolean checkPosition(Coordinates coordinates) {
        GameMap gameMap = GameMap.getInstance();
        if (coordinates.getX() < 0 || coordinates.getY() < 0
                || coordinates.getX() >= gameMap.getMapSize() || coordinates.getY() >= gameMap.getMapSize())
            return false;
        return !gameMap.isObjectHere(coordinates) || gameMap.getObject(coordinates).type == ObjectsEnum.GOAL
                || gameMap.getObject(coordinates).type == ObjectsEnum.PLAYER;
    }

    public static boolean checkPosition(Coordinates coordinates, boolean ignoreGoal) {
        GameMap gameMap = GameMap.getInstance();
        if (coordinates.getX() < 0 || coordinates.getY() < 0
                || coordinates.getX() >= gameMap.getMapSize() || coordinates.getY() >= gameMap.getMapSize())
            return false;
        if (ignoreGoal)
            return !gameMap.isObjectHere(coordinates) || gameMap.getObject(coordinates).type == ObjectsEnum.GOAL
                    || gameMap.getObject(coordinates).type == ObjectsEnum.PLAYER;
        else
            return !gameMap.isObjectHere(coordinates) || gameMap.getObject(coordinates).type == ObjectsEnum.PLAYER;
    }

    private static boolean checkPreviousList(Coordinates coordinate, Set<Coordinates> PreviousList) {
        for (Coordinates LastCoordinate : PreviousList) {
            if (coordinate.equals(LastCoordinate))
                return true;
        }
        return false;
    }

    public static int pathForPlayer(Coordinates coordinates) {
        GameMap gameMap = GameMap.getInstance();
        Map<Coordinates, Integer> pathFinder = new HashMap<>();
        pathFinder.put(coordinates, 0);

        int count = 0;
        do {
            count++;
            Map<Coordinates, Integer> newPathFinder = new HashMap<>(pathFinder);
            for (Coordinates c : pathFinder.keySet()) {
                Coordinates newCoordinates;
                if (newPathFinder.get(c) == 0) {

                    newCoordinates = c.up();
                    if (newCoordinates.equals(gameMap.getGoal().coordinates))
                        return count;
                    if (!checkPreviousList(newCoordinates, newPathFinder.keySet())) {
                        if (checkPosition(newCoordinates))
                            newPathFinder.put(newCoordinates, 0);
                    }

                    newCoordinates = c.down();
                    if (newCoordinates.equals(gameMap.getGoal().coordinates))
                        return count;
                    if (!checkPreviousList(newCoordinates, newPathFinder.keySet())) {
                        if (checkPosition(newCoordinates))
                            newPathFinder.put(newCoordinates, 0);
                    }

                    newCoordinates = c.right();
                    if (newCoordinates.equals(gameMap.getGoal().coordinates))
                        return count;
                    if (!checkPreviousList(newCoordinates, newPathFinder.keySet())) {
                        if (checkPosition(newCoordinates))
                            newPathFinder.put(newCoordinates, 0);
                    }

                    newCoordinates = c.left();
                    if (newCoordinates.equals(gameMap.getGoal().coordinates))
                        return count;
                    if (!checkPreviousList(newCoordinates, newPathFinder.keySet())) {
                        if (checkPosition(newCoordinates))
                            newPathFinder.put(newCoordinates, 0);
                    }

                    newPathFinder.put(c, 1);

                } else
                    newPathFinder.put(c, newPathFinder.get(c) + 1);
            }
            pathFinder = newPathFinder;
        }
        while (count <= gameMap.getMaxPath());
        return gameMap.getMapSize() * gameMap.getMapSize();
    }

    public static int pathForComputer(Coordinates coordinates, Coordinates goal, boolean ignoreGoal) {
        if (coordinates.equals(goal))
            return 0;
        GameMap gameMap = GameMap.getInstance();
        Map<Coordinates, Integer> pathFinder = new HashMap<>();
        pathFinder.put(coordinates, 0);

        int count = 0;
        do {
            count++;
            Map<Coordinates, Integer> newPathFinder = new HashMap<>(pathFinder);
            for (Coordinates c : pathFinder.keySet()) {
                Coordinates newCoordinates;
                if (newPathFinder.get(c) == 0) {

                    newCoordinates = c.up();
                    if (newCoordinates.equals(goal))
                        return count;
                    if (!checkPreviousList(newCoordinates, newPathFinder.keySet())) {
                        if (checkPosition(newCoordinates, ignoreGoal))
                            newPathFinder.put(newCoordinates, 0);
                        else if ((newCoordinates.getX() >= 0 && newCoordinates.getY() >= 0
                                && newCoordinates.getX() < gameMap.getMapSize()
                                && newCoordinates.getY() < gameMap.getMapSize()) &&
                                (gameMap.getObject(newCoordinates).type == ObjectsEnum.PLAYER
                                        || gameMap.getObject(newCoordinates).type == ObjectsEnum.ENEMY))
                            newPathFinder.put(newCoordinates, 0);
                    }

                    newCoordinates = c.down();
                    if (newCoordinates.equals(goal))
                        return count;
                    if (!checkPreviousList(newCoordinates, newPathFinder.keySet())) {
                        if (checkPosition(newCoordinates, ignoreGoal))
                            newPathFinder.put(newCoordinates, 0);
                        else if ((newCoordinates.getX() >= 0 && newCoordinates.getY() >= 0
                                && newCoordinates.getX() < gameMap.getMapSize()
                                && newCoordinates.getY() < gameMap.getMapSize()) &&
                                (gameMap.getObject(newCoordinates).type == ObjectsEnum.PLAYER
                                        || gameMap.getObject(newCoordinates).type == ObjectsEnum.ENEMY))
                            newPathFinder.put(newCoordinates, 0);
                    }

                    newCoordinates = c.right();
                    if (newCoordinates.equals(goal))
                        return count;
                    if (!checkPreviousList(newCoordinates, newPathFinder.keySet())) {
                        if (checkPosition(newCoordinates, ignoreGoal))
                            newPathFinder.put(newCoordinates, 0);
                        else if ((newCoordinates.getX() >= 0 && newCoordinates.getY() >= 0
                                && newCoordinates.getX() < gameMap.getMapSize()
                                && newCoordinates.getY() < gameMap.getMapSize()) &&
                                (gameMap.getObject(newCoordinates).type == ObjectsEnum.PLAYER
                                        || gameMap.getObject(newCoordinates).type == ObjectsEnum.ENEMY))
                            newPathFinder.put(newCoordinates, 0);
                    }

                    newCoordinates = c.left();
                    if (newCoordinates.equals(goal))
                        return count;
                    if (!checkPreviousList(newCoordinates, newPathFinder.keySet())) {
                        if (checkPosition(newCoordinates, ignoreGoal))
                            newPathFinder.put(newCoordinates, 0);
                        else if ((newCoordinates.getX() >= 0 && newCoordinates.getY() >= 0
                                && newCoordinates.getX() < gameMap.getMapSize()
                                && newCoordinates.getY() < gameMap.getMapSize()) &&
                                (gameMap.getObject(newCoordinates).type == ObjectsEnum.PLAYER
                                        || gameMap.getObject(newCoordinates).type == ObjectsEnum.ENEMY))
                            newPathFinder.put(newCoordinates, 0);
                    }

                    newPathFinder.put(c, 1);

                } else
                    newPathFinder.put(c, newPathFinder.get(c) + 1);
            }
            pathFinder = newPathFinder;
        }
        while (count <= gameMap.getMaxPath());
        return gameMap.getMapSize() * gameMap.getMapSize();
    }

    public static void enemyMove(Enemy enemy) {
        GameMap gameMap = GameMap.getInstance();
        Coordinates newCoordinates;
        int pathToGoal = pathForComputer(enemy.coordinates, gameMap.getGoal().coordinates, true);
        if (pathToGoal > gameMap.getMaxPath()) {

            newCoordinates = enemy.coordinates.up();
            if (checkPosition(newCoordinates, false)) {
                enemy.coordinates = newCoordinates;
                return;
            }

            newCoordinates = enemy.coordinates.right();
            if (checkPosition(newCoordinates, false)) {
                enemy.coordinates = newCoordinates;
                return;
            }

            newCoordinates = enemy.coordinates.down();
            if (checkPosition(newCoordinates, false)) {
                enemy.coordinates = newCoordinates;
                return;
            }

            newCoordinates = enemy.coordinates.left();
            if (checkPosition(newCoordinates, false)) {
                enemy.coordinates = newCoordinates;
                return;
            }
            return;
        }

        int pathToPlayer = pathForComputer(enemy.coordinates, gameMap.getPlayer().coordinates, false);
        int pathPlayerToGoal = pathForPlayer(gameMap.getPlayer().coordinates);

        BestMove move = new BestMove();
        move.currentPathToGoal = pathToGoal;
        move.currentPathToPlayer = pathToPlayer;
        move.currentPlayerPath = pathPlayerToGoal;


        newCoordinates = enemy.coordinates.up();
        if (checkPosition(newCoordinates, false))
            move.variants.put(newCoordinates,
                    new BestMove.Pathes(pathForComputer(newCoordinates, gameMap.getPlayer().coordinates, false),
                            pathForComputer(newCoordinates, gameMap.getGoal().coordinates, true)));
        newCoordinates = enemy.coordinates.right();
        if (checkPosition(newCoordinates, false))
            move.variants.put(newCoordinates,
                    new BestMove.Pathes(pathForComputer(newCoordinates, gameMap.getPlayer().coordinates, false),
                            pathForComputer(newCoordinates, gameMap.getGoal().coordinates, true)));
        newCoordinates = enemy.coordinates.down();
        if (checkPosition(newCoordinates, false))
            move.variants.put(newCoordinates,
                    new BestMove.Pathes(pathForComputer(newCoordinates, gameMap.getPlayer().coordinates, false),
                            pathForComputer(newCoordinates, gameMap.getGoal().coordinates, true)));
        newCoordinates = enemy.coordinates.left();
        if (checkPosition(newCoordinates, false))
            move.variants.put(newCoordinates,
                    new BestMove.Pathes(pathForComputer(newCoordinates, gameMap.getPlayer().coordinates, false),
                            pathForComputer(newCoordinates, gameMap.getGoal().coordinates, true)));

        enemy.coordinates = move.getBestMove();


    }

    private static class BestMove{
        Map<Coordinates, Pathes> variants = new HashMap<>();

        int currentPathToGoal;
        int currentPathToPlayer;

        int currentPlayerPath;

        Coordinates getBestMove(){

            if (currentPlayerPath > currentPathToGoal){

                for (Coordinates c: variants.keySet())
                    if (currentPathToPlayer - variants.get(c).pathToPlayer > 0 &&
                            currentPathToGoal - variants.get(c).pathToGoal == 0)
                        return c;

                for (Coordinates c: variants.keySet())
                    if (currentPathToPlayer - variants.get(c).pathToPlayer > 0 &&
                            currentPathToGoal - variants.get(c).pathToGoal < 0)
                        return c;
            }


            for (Coordinates c: variants.keySet())
                if (currentPathToPlayer - variants.get(c).pathToPlayer > 0 &&
                currentPathToGoal - variants.get(c).pathToGoal > 0)
                    return c;

            for (Coordinates c: variants.keySet())
                if (currentPathToPlayer - variants.get(c).pathToPlayer > 0 &&
                        currentPathToGoal - variants.get(c).pathToGoal == 0)
                    return c;

            for (Coordinates c: variants.keySet())
                if (currentPathToPlayer - variants.get(c).pathToPlayer == 0 &&
                        currentPathToGoal - variants.get(c).pathToGoal > 0)
                    return c;

            for (Coordinates c: variants.keySet())
                if (currentPathToPlayer - variants.get(c).pathToPlayer == 0 &&
                        currentPathToGoal - variants.get(c).pathToGoal == 0)
                    return c;

            for (Coordinates c: variants.keySet())
                if (currentPathToPlayer - variants.get(c).pathToPlayer == 0 &&
                        currentPathToGoal - variants.get(c).pathToGoal < 0)
                    return c;

            Coordinates notBest = null;
            for (Coordinates c: variants.keySet())
                notBest = c;
            return notBest;
        }

        public static class Pathes{
            public Pathes(int pathToPlayer, int pathToGoal){
                this.pathToGoal = pathToGoal;
                this.pathToPlayer = pathToPlayer;
            }
            int pathToGoal;
            int pathToPlayer;
        }
    }

    public static boolean hasMove(){
        GameMap gameMap = GameMap.getInstance();
        return checkPosition(gameMap.getPlayer().coordinates.up())
                || checkPosition(gameMap.getPlayer().coordinates.right())
                || checkPosition(gameMap.getPlayer().coordinates.down())
                || checkPosition(gameMap.getPlayer().coordinates.left());
    }

}
