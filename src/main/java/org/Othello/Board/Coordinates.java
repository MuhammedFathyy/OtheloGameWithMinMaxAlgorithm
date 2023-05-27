package org.Othello.Board;

import java.util.List;

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

    public static List<Coordinates> generateCoordinates(Board board , boolean maximizingPlayer)
    {
        return null;
    }
}
