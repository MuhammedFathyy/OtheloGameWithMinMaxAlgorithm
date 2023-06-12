package org.Othello.MiniMax;

import org.Othello.Board.Board;
import org.Othello.Board.Coordinates;

public class IterativeDeepening {
    private static final MinimaxWithAlphaBeta minimaxAlphaBeta = new MinimaxWithAlphaBeta();

    public Coordinates findBestMove(Board board, int MAX_DEPTH, long TIME_LIMIT, String diff) {
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
