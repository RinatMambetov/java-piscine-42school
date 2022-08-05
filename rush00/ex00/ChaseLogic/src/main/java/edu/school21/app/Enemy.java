package edu.school21.app;

public class Enemy extends GameObjects {


    Enemy(Coordinates coordinates) {
        super(coordinates);
        type = ObjectsEnum.ENEMY;
    }
}
