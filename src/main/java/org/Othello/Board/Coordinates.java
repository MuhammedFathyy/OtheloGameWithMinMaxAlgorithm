package org.Othello.Board;

import java.util.List;

public class Coordinates {
    
    /**
     * Down moving unit vector.
     */
    public static final Coordinates DOWN = new Coordinates(0,1);
    /**
     * Up moving unit vector.
     */
    public static final Coordinates UP = new Coordinates(0,-1);
    /**
     * Left moving unit vector.
     */
    public static final Coordinates LEFT = new Coordinates(-1,0);
    /**
     * Right moving unit vector.
     */
    public static final Coordinates RIGHT = new Coordinates(1,0);
    /**
     * Zero unit vector.
     */
    public static final Coordinates ZERO = new Coordinates(0,0);


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

//    public static List<Coordinates> generateCoordinates(Board board , int playerNumber)
//    {
//
//        return null;
//    }
    
    
    


    public Coordinates(Coordinates CoordinatesToCopy) {
        this.xCoordinates = CoordinatesToCopy.xCoordinates;
        this.yCoordinates = CoordinatesToCopy.yCoordinates;
    }

    /**
     * Sets the Position to the specified x and y coordinate.
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     */
    public void setCoordinates(int x, int y) {
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
    }

 
    public void add(Coordinates otherCoordinates) {
        this.xCoordinates += otherCoordinates.xCoordinates;
        this.yCoordinates += otherCoordinates.yCoordinates;
    }

    public double distanceTo(Coordinates otherCoordinates) {
        return Math.sqrt(Math.pow(xCoordinates-otherCoordinates.xCoordinates,2)+Math.pow(yCoordinates-otherCoordinates.yCoordinates,2));
    }

    /**
     * Multiplies both components of the position by an amount.
     *
     * @param amount Amount to multiply vector by.
     */
    public void multiply(int amount) {
        xCoordinates *= amount;
        yCoordinates *= amount;
    }


    public void subtract(Coordinates otherCoordinates) {
        this.xCoordinates -= otherCoordinates.xCoordinates;
        this.yCoordinates -= otherCoordinates.yCoordinates;
    }
     /**
     * Gets a string version of the Position.
     *
     * @return A string in the form (x, y)
     */
    @Override
    public String toString(){
    return "(" + xCoordinates + ", "+ yCoordinates + ") ";
    }
        


    /**
     * Compares the Position object against another object.
     * Any non-Position object will return false. Otherwise compares x and y for equality.
     *
     * @param o Object to compare this Position against.
     * @return True if the object o is equal to this position for both x and y.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates Coordinates = (Coordinates) o;
        return xCoordinates == Coordinates.xCoordinates && yCoordinates == Coordinates.yCoordinates;
    }

   
}