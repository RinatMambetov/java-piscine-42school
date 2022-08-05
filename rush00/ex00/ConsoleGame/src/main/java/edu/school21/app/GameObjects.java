package edu.school21.app;

public class GameObjects {

    public GameObjects(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public void moveUp(){
        coordinates.setY(coordinates.getY() - 1);
    }

    public void moveDown(){
        coordinates.setY(coordinates.getY() + 1);
    }

    public void moveRight(){
        coordinates.setX(coordinates.getX() + 1);
    }

    public void moveLeft(){
        coordinates.setX(coordinates.getX() - 1);
    }

    public Coordinates coordinates;

    public ObjectsEnum type;

}
