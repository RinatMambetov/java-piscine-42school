package edu.school21.app;

public class Coordinates {
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordinates up(){
        return new Coordinates(x, y - 1);
    }

    public Coordinates down(){
        return new Coordinates(x, y + 1);
    }

    public Coordinates left(){
        return new Coordinates(x - 1, y);
    }

    public Coordinates right(){
        return new Coordinates(x + 1, y);
    }

    public boolean equals(Coordinates coordinates){
        if (coordinates == null)
            return false;
        return coordinates.getX() == x && coordinates.getY() == y;
    }


    private int x, y;
}
