package org.Othello.MiniMax;

import org.Othello.Board.Board;
import org.Othello.Board.Coordinates;

public class IterativeDeepening {
    private int MAX_DEPTH = 2;
    private long TIME_LIMIT = 2000;
    private static final MinimaxWithAlphaBeta minimaxAlphaBeta = new MinimaxWithAlphaBeta();

    public Coordinates findBestMove(Board board, String diff) {
        MAX_DEPTH =  (diff.equalsIgnoreCase("HARD"))? MAX_DEPTH * 3 : MAX_DEPTH;
        TIME_LIMIT =  (diff.equalsIgnoreCase("HARD"))? TIME_LIMIT * 3 : TIME_LIMIT;
        long startTime = System.currentTimeMillis();
        Coordinates bestMove = null;

        for (int depth = 1; depth <= MAX_DEPTH; depth++) {
            bestMove = minimaxAlphaBeta.minimaxAlphaBeta(board, depth, MAX_DEPTH, diff);
            long currentTime = System.currentTimeMillis();

            if (currentTime - startTime >= TIME_LIMIT) {
                break; // Time limit reached, stop searching
            }
        }

        return bestMove;
}

}