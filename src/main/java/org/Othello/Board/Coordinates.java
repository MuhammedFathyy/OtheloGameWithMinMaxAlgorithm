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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same object reference
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false; // Not the same class or null
        }

        Coordinates coordinates = (Coordinates) obj;

        return this.getxCoordinates() ==coordinates.getxCoordinates()
                && this.getyCoordinates() == coordinates.getyCoordinates();
    }
}
