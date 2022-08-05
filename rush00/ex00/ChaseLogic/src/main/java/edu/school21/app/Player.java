package edu.school21.app;

public class Player extends GameObjects{

    public Player(Coordinates coordinates) {
        super(coordinates);
        type = ObjectsEnum.PLAYER;
    }
}
