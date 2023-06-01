package org.Othello.Board;

import org.Othello.Heuristic.CornerCapturedHeuristic;

import java.util.List;


public class GameStatus {

    public static boolean gameIsOver(Board board)
    {
        return false;
    }

    public static int evaluate(Board board, boolean Player)
    {
        //List<Coordinates> availableMoves = generateCoordinates(board , Player);

        CornerCapturedHeuristic cornerCapturedHeuristic = new CornerCapturedHeuristic();
        int score = cornerCapturedHeuristic.getScore(board,Player);

        return  score;
    }
}
