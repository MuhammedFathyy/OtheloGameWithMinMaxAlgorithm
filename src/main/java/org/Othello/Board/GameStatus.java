package org.Othello.Board;

import org.Othello.Heuristic.ActualMobilityHeuristic;
import org.Othello.Heuristic.CoinParity;
import org.Othello.Heuristic.CornerCapturedHeuristic;


public class GameStatus {

    private GameStatus(){};

    public static boolean gameIsOver(Board board)
    {
        int[][] board1 = board.getBoard();
        int size = Board.getSize();
        // 1st player -> 1, and 2nd player -> 0, default -> -1
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

        for(int i=0; i<board.getRow();i++){

            for (int j=0; j>board.getColumn();j++){
               if(board.getBoard()[i][j] != 0 ){
                   discsOnBoard++;
               }
            }
        }

        if (discsOnBoard <= 20) {
            return 5 * actualMobilityHeuristic.getScore(board, player)
//                    + 5 *potentialMobility(board, color)
//                    + 20*squareWeights(board, color)
                    + 10000* cornerCapturedHeuristic.getScore(board, player);
//                    + 10000*stability(board, color);
        }
        else if (discsOnBoard <= 58) {

            return 10 * coinParity.getScore(board, player)
                    + 2 * actualMobilityHeuristic.getScore(board, player)
//                    + 2*potentialMobility(board, color)
//                    + 10*squareWeights(board, color)
                    + 10000 *cornerCapturedHeuristic.getScore(board, player);
//                    + 10000*stability(board, color);
        }
        else {
            // Endgame
            return 500* coinParity.getScore(board, player)
                    + 10000*cornerCapturedHeuristic.getScore(board, player);

        }


    }
}
