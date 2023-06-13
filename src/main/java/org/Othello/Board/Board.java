package org.Othello.Board;

public class Board  {

    private static final int SIZE = 8;

    private int[][] board = new int[SIZE][SIZE];

    public Board(int[][] board) {
        this.board = board;
    }

    public Board() {
        for(int i=0;i<8;i++ ){
            for(int j=0;i<8;j++){
                board[i][j]=0;
            }
        }
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

    public static int getSize(){
        return SIZE;
    }

    
    public void setBoard(int[][] board) {
        this.board = board;
    }
    
   
}
