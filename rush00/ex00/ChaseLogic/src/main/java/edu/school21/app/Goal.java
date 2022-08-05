package edu.school21.app;

public class Goal extends GameObjects{

    public Goal(Coordinates coordinates) {
        super(coordinates);
        type = ObjectsEnum.GOAL;
    }
}
