package org.Othello.Board;

public class Board  {

    private static final int SIZE = 8;

    private int[][] board = new int[SIZE][SIZE];

    public Board(int[][] board) {
        this.board = board;
    }

    public Board() {
        for(int )
    }
     public Board(Coordinates position, int width, int height, int gridWidth, int gridHeight) {
        super(position, width, height);
        grid = new GridCell[gridWidth][gridHeight];
        int cellWidth = (width-position.x)/gridWidth;
        int cellHeight = (height-position.y)/gridHeight;
        for(int x = 0; x < gridWidth; x++) {
            for(int y = 0; y < gridHeight; y++) {
                grid[x][y] = new GridCell(new Position(position.x+cellWidth*x, position.y+cellHeight*y),
                        cellWidth, cellHeight);
            }
        }
        moveNumber = 0;
        validMoves = new ArrayList<>();
        updateValidMoves(1);
    }

    public int getRow()
    {
        return 8;
    }
    public int getColumn()
    {
        return 8;
    }

    public int[][] getBoard() {
        //to be implemented
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    public static int getSize() {return SIZE;}
}
