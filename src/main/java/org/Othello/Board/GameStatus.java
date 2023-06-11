package org.Othello.Board;

import org.Othello.Heuristic.ActualMobilityHeuristic;
import org.Othello.Heuristic.CornerCapturedHeuristic;


public class GameStatus {

    private GameStatus(){};

    public static boolean gameIsOver(Board board)
    {
        int size = Board.getSize();
        // 1st player -> 1, and 2nd player -> 0, default -> -1
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getBoard()[i][j] == -1) return false;
            }
        }
        return true;
    }

    public static int evaluate(Board board, boolean Player)
    {


        CornerCapturedHeuristic cornerCapturedHeuristic = new CornerCapturedHeuristic();
        ActualMobilityHeuristic actualMobilityHeuristic= new ActualMobilityHeuristic();
        int cornerCapturedHeuristicScore = cornerCapturedHeuristic.getScore(board,Player);
        int ActualMobilityHeuristicScore = actualMobilityHeuristic.getScore(board,Player);

        //the score must be calculated based on all the heuristics
        return 0;
    }
}
