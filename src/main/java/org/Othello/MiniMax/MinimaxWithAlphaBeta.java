package org.Othello.MiniMax;

import org.Othello.Board.Board;
import org.Othello.Board.Coordinates;

import java.util.List;

import static org.Othello.Board.GameStatus.evaluate;
import static org.Othello.Board.GameStatus.gameIsOver;
import static org.Othello.Board.Moves.getAvailableMoves;
import static org.Othello.Board.Moves.makeMove;

public class MinimaxWithAlphaBeta {

    public Coordinates minimaxAlphaBeta(Board board, int depth,int playerNumber , String difficulty) {
        boolean maximizingPlayer= true;
        //return the available moves
        List<Coordinates> possibleCoordinates = getAvailableMoves(board, playerNumber);
        Coordinates result = null;
        int bestValue = Integer.MIN_VALUE;
        depth = (difficulty.toLowerCase().equals("hard"))? 5 : 3;
        for (Coordinates coordinates : possibleCoordinates) {
            Board newBoard = makeMove(board, coordinates,playerNumber);
            int value = maxValue(newBoard, depth - 1, !maximizingPlayer
                    , playerNumber, Integer.MIN_VALUE, Integer.MAX_VALUE);

            if (value > bestValue) {
                bestValue = value;
                result = coordinates;
            }
        }

        return result;
    }

    private int maxValue(Board board, int depth, Boolean maximizingPlayer,int playerNumber,
                         int alpha, int beta) {

        if (depth == 0 || gameIsOver(board)) {
            return evaluate(board , playerNumber);
        }

        List<Coordinates> possibleMoves = getAvailableMoves(board, playerNumber);

        for (Coordinates move : possibleMoves) {
            Board newBoard = makeMove(board, move,playerNumber);

            alpha =  Math.max(alpha, minValue(newBoard, depth - 1,
                    !maximizingPlayer,playerNumber, alpha, beta ));
            //alpha = maximizingPlayer? Math.max(alpha, maxValue(newBoard, depth - 1, maximizingPlayer, alpha, beta)):alpha;
            //beta = maximizingPlayer? beta:Math.min(beta, maxValue(newBoard, depth - 1, !maximizingPlayer, alpha, beta));

            if (alpha >= beta) {
                break;  // Alpha-Beta Pruning
            }
        }

        return maximizingPlayer? alpha:beta;
    }

    private int minValue(Board board, int depth, Boolean minimizingPlayer,int playerNumber,
                         int alpha, int beta ) {
        if (depth == 0 || gameIsOver(board)) {
            return evaluate(board ,playerNumber );
        }

        List<Coordinates> possibleMoves = getAvailableMoves(board, playerNumber);

        for (Coordinates move : possibleMoves) {
            //we should send the player number
            Board newBoard = makeMove(board, move,playerNumber);
            beta = Math.min(beta, maxValue(newBoard, depth - 1,
                    !minimizingPlayer,playerNumber, alpha, beta ));

            if (beta <= alpha) {
                break;  // Alpha-Beta Pruning
            }
        }

        return beta;
    }
}