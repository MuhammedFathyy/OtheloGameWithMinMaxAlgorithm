package org.Othello.Heuristic;

import org.Othello.Board.Board;
import org.Othello.Board.Coordinates;
import org.Othello.Board.Moves;

import java.util.List;

public class ActualMobilityHeuristic {


    public int getScore(Board currentBoard, boolean Player){

        List<Coordinates> coordinatesList= Moves.getAvailableMoves(currentBoard,Player);
        return coordinatesList.size();

    }
}
