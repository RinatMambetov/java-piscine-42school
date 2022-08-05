package edu.school21.app;

public class Wall extends GameObjects{

    Wall(Coordinates coordinates) {
        super(coordinates);
        type = ObjectsEnum.WALL;
    }
}
