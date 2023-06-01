package org.Othello.Heuristic;

import org.Othello.Board.Board;
import org.Othello.Board.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;


public class CornerCapturedHeuristic {

    private ArrayList<Coordinates> corners = new ArrayList<Coordinates>(Arrays.asList(
            new Coordinates(0, 0),
            new Coordinates(7, 0),
            new Coordinates(0, 7),
            new Coordinates(7, 7)
    ));

    private final int heuristicScore = 100;

    public CornerCapturedHeuristic() {
    }

    public int getScore(Board currentBoard, boolean player) {

        int playerOneScore = 0;
        int playerTwoScore = 0;
        int cornerCapturedScore = 0;

        int[][] board = currentBoard.getBoard();


        for (int cornerIndex = 0; cornerIndex < corners.size(); cornerIndex++) {

            Coordinates corner = corners.get(cornerIndex);
            if (board[corner.getxCoordinates()][corner.getyCoordinates()] == 1) {
                playerOneScore += 10;
            } else if (board[corner.getxCoordinates()][corner.getyCoordinates()] == 0) {
                playerTwoScore += 10;
            }
        }
        if (playerOneScore + playerTwoScore != 0)
        {
            cornerCapturedScore = (heuristicScore * (playerOneScore - playerTwoScore)) / (playerOneScore + playerTwoScore);
        }
        else{
            cornerCapturedScore = 0;
        }
        return cornerCapturedScore;
    }

}



