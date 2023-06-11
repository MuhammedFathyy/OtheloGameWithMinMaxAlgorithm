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

    public int getScore(Board currentBoard, int player) {

        int playerOneScore = 0;
        int playerTwoScore = 0;
        int cornerCapturedScore = 0;

        //get the current board based on the move
        int[][] board = currentBoard.getBoard();


        for (int cornerIndex = 0; cornerIndex < corners.size(); cornerIndex++) {

            Coordinates corner = corners.get(cornerIndex);
            if (board[corner.getxCoordinates()][corner.getyCoordinates()] == 1) {
                playerOneScore ++;
            } else if (board[corner.getxCoordinates()][corner.getyCoordinates()] == 0) {
                playerTwoScore ++;
            }
        }
        if (player==1) {
            return 100 * (playerOneScore - playerTwoScore)
                    / (playerOneScore + playerTwoScore + 1);
        }
        else {
            return 100 * (playerTwoScore - playerOneScore)
                    / (playerOneScore + playerTwoScore + 1);
        }
    }

}



