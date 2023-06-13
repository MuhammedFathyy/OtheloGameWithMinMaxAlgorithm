package org.Othello.Board;

import org.Othello.Heuristic.*;


public class GameStatus {

    private GameStatus(){}

    public static boolean gameIsOver(Board board)
    {
        int[][] board1 = board.getBoard();
        int size = Board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board1[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static int evaluate(Board board, int player)
    {
        int discsOnBoard = 0;

        CornerCapturedHeuristic cornerCapturedHeuristic = new CornerCapturedHeuristic();
        ActualMobilityHeuristic actualMobilityHeuristic= new ActualMobilityHeuristic();
        CoinParity coinParity= new CoinParity();
        PotentialMobilityHeuristic potentialMobilityHeuristic= new PotentialMobilityHeuristic();
        StabilityHeuristic stabilityHeuristic = new StabilityHeuristic();

        for(int i=0; i<board.getRow();i++){

            for (int j=0; j<board.getColumn();j++){
                if(board.getBoard()[i][j] != 0 ){
                    discsOnBoard++;
                }
            }
        }

        if (discsOnBoard <= 20) {
            //start of the game
            return 5 * actualMobilityHeuristic.getScore(board, player) +
                    5 * potentialMobilityHeuristic.getScore(board, player) +
                    10000 * cornerCapturedHeuristic.getScore(board, player) +
                    10000 * stabilityHeuristic.getScore(board , player);

        }
        else if (discsOnBoard <= 58) {

            //middle of the game
            return 10 * coinParity.getScore(board, player)+
                    2 * actualMobilityHeuristic.getScore(board, player) +
                    2 * potentialMobilityHeuristic.getScore(board, player) +
                    10000 * cornerCapturedHeuristic.getScore(board, player) +
                    10000 * stabilityHeuristic.getScore(board , player);

        }
        else {
            // End of the game
            return 500 * coinParity.getScore(board, player) +
                    10000 * cornerCapturedHeuristic.getScore(board, player) +
                    10000 * stabilityHeuristic.getScore(board , player);

   }

    }
}