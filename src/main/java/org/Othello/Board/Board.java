package org.Othello.Board;

public class Board {

    private static final int SIZE = 8;

    private int[][] board = new int[SIZE][SIZE];

    public Board(int[][] board) {
        this.board = board;
    }

    public Board() {
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
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}
