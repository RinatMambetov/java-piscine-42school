package edu.school21.app;

import java.util.ArrayList;
import java.util.List;

public class ListWalls {

    public void add(Coordinates coordinates){
        walls.add(new Wall(coordinates));
    }

    public void clear(){
        walls.clear();
    }

    public boolean isWall(Coordinates coordinates){
        for (Wall item : walls){
            if (item.coordinates.equals(coordinates))
                return true;
        }
        return false;
    }

    public Wall getWall(Coordinates coordinates){
        for (Wall item : walls){
            if (item.coordinates.equals(coordinates))
                return item;
        }
        return null;
    }

    public void deleteWall(Coordinates coordinates){
        if (coordinates != null){
            Wall wall = getWall(coordinates);
            walls.remove(wall);
        }
    }

    public static ListWalls getInstance(){
        return instance;
    }

    private static final ListWalls instance = new ListWalls();

    private ListWalls() {
    }

    private final List<Wall> walls = new ArrayList<>();
}
