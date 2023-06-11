
package org.Othello.Board;

public class Rectangle {
    /**
     * The top left corner of the Rectangle.
     */
    protected Coordinates position;
    /**
     * Width of the Rectangle.
     */
    protected int width;
    /**
     * Height of the Rectangle.
     */
    protected int height;

    /**
     * Creates the new Rectangle with provided properties.
     *
     * @param position The top left corner of the Rectangle.
     * @param width Width of the Rectangle.
     * @param height Height of the Rectangle.
     */
    public Rectangle(Coordinates position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    /**
     * @param x X coordinate of the top left corner.
     * @param y Y coordinate of the top left corner.
     * @param width Width of the rectangle.
     * @param height Height of the rectangle.
     */
    public Rectangle(int x, int y, int width, int height) {
        this(new Coordinates(x,y),width,height);
    }

    public Rectangle() {

    }

    /**
     * Gets the height of the Rectangle.
     *
     * @return Height of the Rectangle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the width of the Rectangle.
     *
     * @return Width of the Rectangle.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the top left corner of the Rectangle.
     *
     * @return Top left corner of the Rectangle.
     */
    public Coordinates getPosition() {
        return position;
    }

    /**
     * Gets the centre of the rectangle based on stored values.
     *
     * @return Centre coordinates of the rectangle.
     */
    public Coordinates getCentre() {
        return new Coordinates(position.getxCoordinates() + width/2, position.getyCoordinates() + height/2);
    }

    /**
     * Tests if the targetPosition is inside the Rectangle.
     *
     * @param targetPosition Position to test if it is inside the Rectangle.
     * @return True if the targetPosition is inside this Rectangle.
     */
    public boolean isPositionInside(Coordinates targetPosition) {
        return targetPosition.getxCoordinates() >= position.getxCoordinates() && targetPosition.getyCoordinates() >= position.getyCoordinates()
                && targetPosition.getxCoordinates() < position.getxCoordinates() + width && targetPosition.getyCoordinates() < position.getyCoordinates() + height;
    }

    /**
     * Tests the Rectangle is intersecting with some otherRectangle.
     *
     * @param otherRectangle Other position to compare against for a collision.
     * @return True if this Rectangle is intersecting the otherRectangle.
     */
    public boolean isIntersecting(Rectangle otherRectangle) {
        // break if any of the following are true because it means they don't intersect
        if(position.getyCoordinates() + height < otherRectangle.position.getyCoordinates()) return false;
        if(position.getyCoordinates() > otherRectangle.position.getyCoordinates() + otherRectangle.height) return false;
        if(position.getxCoordinates() + width < otherRectangle.position.getxCoordinates()) return false;
        if(position.getxCoordinates() > otherRectangle.position.getxCoordinates() + otherRectangle.width) return false;

        // the bounding boxes do intersect
        return true;
    }
}