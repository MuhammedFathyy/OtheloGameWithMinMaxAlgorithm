package org.Othello.Board;

public class Board {

    public static final int SIZE = 10;

    private int[][] board = new int[SIZE][SIZE];

    public Board(int[][] board) {
        this.board = board;
    }

    public Board() {
    }
}
