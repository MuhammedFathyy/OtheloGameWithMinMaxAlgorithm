package org.Othello.Heuristic;

import org.Othello.Board.Board;

public class CoinParity {

    public int getScore(Board currentBoard, int player) {
        int myScore = 0;
        int oppScore = 0;
//        int playerToScore = player? 1:0;
        int[][] board = currentBoard.getBoard();
        for (int i = 0; i < Board.getSize();i++) {
            for (int j = 0; j < Board.getSize(); j++) {
                if (board[i][j] == player) myScore++;
                else oppScore++;
            }
        }
        return 100 * (myScore - oppScore) / (myScore + oppScore);
    }
}
