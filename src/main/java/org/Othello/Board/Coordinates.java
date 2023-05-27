package org.Othello.Board;

public class Coordinates {

    private int xCoordinates;
    private int yCoordinates;

    public Coordinates(int xCoordinates, int yCoordinates) {
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
    }

    public Coordinates() {
    }

    public int getxCoordinates() {
        return xCoordinates;
    }

    public void setxCoordinates(int xCoordinates) {
        this.xCoordinates = xCoordinates;
    }

    public int getyCoordinates() {
        return yCoordinates;
    }

    public void setyCoordinates(int yCoordinates) {
        this.yCoordinates = yCoordinates;
    }
}
