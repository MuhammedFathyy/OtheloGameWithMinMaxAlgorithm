package org.Othello.Board;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Grid extends Rectangle {

    public GridCell[][] getGrid() {
        return grid;
    }

    private GridCell[][] grid;

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public List<Coordinates> getValidMoves() {
        return validMoves;
    }

    public void setValidMoves(List<Coordinates> validMoves) {
        this.validMoves = validMoves;
    }

    private int moveNumber;
    private List<Coordinates> validMoves;
    public Grid(Coordinates position, int width, int height, int gridWidth, int gridHeight) {
        super(position, width, height);

        grid = new GridCell[gridWidth][gridHeight];
        int cellWidth = (width-position.getxCoordinates())/gridWidth;
        int cellHeight = (height-position.getyCoordinates())/gridHeight;
        for(int x = 0; x < gridWidth; x++) {
            for(int y = 0; y < gridHeight; y++) {
                grid[x][y] = new GridCell(new Coordinates(position.getxCoordinates()+cellWidth*x, position.getyCoordinates()+cellHeight*y),
                        cellWidth, cellHeight);
            }
        }
        moveNumber = 0;
        validMoves = new ArrayList<>();

    }


    public void paint(Graphics g) {
        drawGridLines(g);
        for(int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                grid[x][y].paint(g);
            }
        }
    }

    private void drawGridLines(Graphics g) {
        g.setColor(Color.BLACK);
        // Draw vertical lines
        int y2 = position.getyCoordinates()+height;
        int y1 = position.getyCoordinates();
        for(int x = 0; x < grid.length+1; x++)
            g.drawLine(position.getxCoordinates()+x * grid[0][0].width, y1, position.getxCoordinates()+x * grid[0][0].width, y2);

        // Draw horizontal lines
        int x2 = position.getxCoordinates()+width;
        int x1 = position.getxCoordinates();
        for(int y = 0; y < grid[0].length+1; y++)
            g.drawLine(x1, position.getyCoordinates()+y * grid[0][0].height, x2, position.getyCoordinates()+y * grid[0][0].height);
}
}