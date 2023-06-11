package org.Othello.MiniMax;

import org.Othello.Board.Board;
import org.Othello.Board.Coordinates;
import org.Othello.Board.Moves;

import java.util.*;

import static org.Othello.Board.GameStatus.evaluate;
import static org.Othello.Board.GameStatus.gameIsOver;
import static org.Othello.Board.Moves.getAvailableMoves;
import static org.Othello.Board.Moves.makeMove;

public class MinimaxWithAlphaBeta {

    public Coordinates minimaxAlphaBeta(Board board, int depth, Boolean maximizingPlayer) {
        //return the available moves
        List<Coordinates> possibleCoordinates = getAvailableMoves(board, maximizingPlayer);
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
            return evaluate(board , maximizingPlayer);
        }

        List<Coordinates> possibleMoves = getAvailableMoves(board, maximizingPlayer);

        for (Coordinates move : possibleMoves) {
            Board newBoard = makeMove(board, move);

            alpha =  Math.max(alpha, minValue(newBoard, depth - 1, !maximizingPlayer, alpha, beta));
            //alpha = maximizingPlayer? Math.max(alpha, maxValue(newBoard, depth - 1, maximizingPlayer, alpha, beta)):alpha;
            //beta = maximizingPlayer? beta:Math.min(beta, maxValue(newBoard, depth - 1, !maximizingPlayer, alpha, beta));

            if (alpha >= beta) {
                break;  // Alpha-Beta Pruning
            }
        }

        return maximizingPlayer? alpha:beta;
    }

    private int minValue(Board board, int depth, Boolean minimizingPlayer, int alpha, int beta) {
        if (depth == 0 || gameIsOver(board)) {
            return evaluate(board , minimizingPlayer);
        }

        List<Coordinates> possibleMoves = getAvailableMoves(board, minimizingPlayer);

        for (Coordinates move : possibleMoves) {
            Board newBoard = makeMove(board, move);
            beta = Math.min(beta, maxValue(newBoard, depth - 1, !minimizingPlayer, alpha, beta));

            if (beta <= alpha) {
                break;  // Alpha-Beta Pruning
            }
        }

        return beta;
    }
}
