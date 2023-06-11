package org.Othello.Heuristic;

import org.Othello.Board.Board;
import org.Othello.Board.Coordinates;
import org.Othello.Board.Moves;

import java.util.List;

public class ActualMobilityHeuristic {

    public int getScore(Board currentBoard, int player){
        List<Coordinates> blackMoves= Moves.getAvailableMoves(currentBoard,1);
        List <Coordinates> whiteMoves = Moves.getAvailableMoves(currentBoard,2);


        if (player == 1) {
            return 100 * (blackMoves.size() - whiteMoves.size()) / (blackMoves.size() + whiteMoves.size() + 1);
        }
        else {
            return 100 * (whiteMoves.size() - blackMoves.size()) / (blackMoves.size() + whiteMoves.size() + 1);
        }

    }
}
