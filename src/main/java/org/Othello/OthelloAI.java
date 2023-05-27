package org.Othello;

import org.Othello.Board.Board;
import org.Othello.Board.Coordinates;

import java.util.*;

import static org.Othello.Board.Coordinates.generateCoordinates;
import static org.Othello.Board.GameStatus.evaluate;
import static org.Othello.Board.GameStatus.gameIsOver;
import static org.Othello.Board.Moves.makeMove;

public class OthelloAI {
    // Other code...

    public Coordinates minimaxAlphaBeta(Board board, int depth, Boolean maximizingPlayer) {
        List<Coordinates> possibleCoordinates = generateCoordinates(board, maximizingPlayer);
        Coordinates result = null;
        int bestValue = Integer.MIN_VALUE;

        for (Coordinates coordinates : possibleCoordinates) {
            Board newBoard = makeMove(board, coordinates);
            int value = maxValue(newBoard, depth - 1, !maximizingPlayer, Integer.MIN_VALUE, Integer.MAX_VALUE);

            if (value > bestValue) {
                bestValue = value;
                result = coordinates;
            }
        }

        return result;
    }

    private int maxValue(Board board, int depth, Boolean maximizingPlayer, int alpha, int beta) {
        if (depth == 0 || gameIsOver(board)) {
            return evaluate(board);
        }

        List<Coordinates> possibleMoves = generateCoordinates(board, maximizingPlayer);

        for (Coordinates move : possibleMoves) {
            Board newBoard = makeMove(board, move);

            alpha = maximizingPlayer? Math.max(alpha, maxValue(newBoard, depth - 1, maximizingPlayer, alpha, beta)):alpha;
            beta = maximizingPlayer? beta:Math.min(beta, maxValue(newBoard, depth - 1, !maximizingPlayer, alpha, beta));

            if (alpha >= beta) {
                break;  // Alpha-Beta Pruning
            }
        }

        return maximizingPlayer? alpha:beta;
    }
//
//    private int minValue(Board board, int depth, Boolean minimizingPlayer, int alpha, int beta) {
//        if (depth == 0 || gameIsOver(board)) {
//            return evaluate(board);
//        }
//
//        List<Coordinates> possibleMoves = generateCoordinates(board, minimizingPlayer);
//
//        for (Move move : possibleMoves) {
//            Board newBoard = makeMove(board, move);
//            beta = Math.min(beta, maxValue(newBoard, depth - 1, minimizingPlayer.opposite(), alpha, beta));
//
//            if (beta <= alpha) {
//                break;  // Alpha-Beta Pruning
//            }
//        }
//
//        return beta;
//    }
}
