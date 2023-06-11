package org.Othello.Heuristic;

import com.sun.tools.javac.util.Pair;
import org.Othello.Board.Board;

import java.util.ArrayList;

public class PotentialMobilityHeuristic {
    public int getScore(Board currentBoard, int player) {
        int myPotentialMobility = playerPotentialMobility(currentBoard, (player == 1)? 1:-1);
        int opponentPotentialMobility = playerPotentialMobility(currentBoard, (player == 1)? -1:1);

        return 100 * (myPotentialMobility - opponentPotentialMobility)
                / (myPotentialMobility + opponentPotentialMobility + 1);
    }

    private int playerPotentialMobility(Board currentBoard, int color) {
        int[][] myBoard = currentBoard.getBoard();
        ArrayList<Pair<Integer, Integer>> squares = new ArrayList<>();
        for (int i = 2; i <= 5; i++) {
            for (int j = 2; j <= 5; j++) {
                squares.add(new Pair<>(i,j));
            }
        }
//                18, 19, 20, 21,   2,2   2,3     2,4     2,5
//                26, 27, 28, 29,
//                34, 35, 36, 37,
//                42, 43, 44, 45};  5,2 -> 5,5

        int here = 0, up = 0, down = 0, left = 0, right = 0,
                upperLeft = 0, upperRight = 0, lowerLeft = 0, lowerRight = 0;
        int potentialMobility = 0;

        for (Pair<Integer, Integer> square : squares) {
            here = myBoard[square.fst][square.snd];
            up = myBoard[square.fst - 1][square.snd];
            down = myBoard[square.fst + 1][square.snd];
            left = myBoard[square.fst][square.snd - 1];
            right = myBoard[square.fst][square.snd + 1];
            upperLeft = myBoard[square.fst - 1][square.snd - 1];
            upperRight = myBoard[square.fst - 1][square.snd + 1];
            lowerLeft = myBoard[square.fst + 1][square.snd - 1];
            lowerRight = myBoard[square.fst + 1][square.snd + 1];

            if (here == -color && up == 0)
                potentialMobility++;
            if (here == -color && down == 0)
                potentialMobility++;
            if (here == -color && right == 0)
                potentialMobility++;
            if (here == -color && right == 0)
                potentialMobility++;
            if (here == -color && upperLeft == 0)
                potentialMobility++;
            if (here == -color && upperRight == 0)
                potentialMobility++;
            if (here == -color && lowerLeft == 0)
                potentialMobility++;
            if (here == -color && lowerRight == 0)
                potentialMobility++;
        }

        ArrayList<Pair<Integer, Integer>> topRow = new ArrayList<>();
        for (int i = 2; i <= 4; i++) topRow.add(new Pair<>(1, i));
        for (Pair<Integer, Integer> square : topRow) {
            here = myBoard[square.fst][square.snd];
            left = myBoard[square.fst][square.snd - 1];
            right = myBoard[square.fst][square.snd + 1];
            if (here == -color && left == 0)
                potentialMobility++;
            if (here == -color && right == 0)
                potentialMobility++;
        }

        ArrayList<Pair<Integer, Integer>> bottomRow = new ArrayList<>();
        for (int i = 2; i <= 4; i++) bottomRow.add(new Pair<>(6, i));
//      {50, 51, 52, 53}
        for (Pair<Integer, Integer> square : bottomRow) {
            here = myBoard[square.fst][square.snd];
            left = myBoard[square.fst][square.snd];
            right = myBoard[square.fst][square.snd];
            if (here == -color && left == 0)
                potentialMobility++;
            if (here == -color && right == 0)
                potentialMobility++;
        }

        ArrayList<Pair<Integer, Integer>> leftColumn = new ArrayList<>();
        for (int i = 2; i <= 4; i++) leftColumn.add(new Pair<>(i, 1));
//        {17, 25, 33, 41};
        for (Pair<Integer, Integer> square : leftColumn) {
            here = myBoard[square.fst][square.snd];
            up = myBoard[square.fst - 1][square.snd];
            down = myBoard[square.fst + 1][square.snd];
            if (here == -color && up == 0)
                potentialMobility++;
            if (here == -color && down == 0)
                potentialMobility++;
        }

        ArrayList<Pair<Integer, Integer>> rightColumn = new ArrayList<>();
        for (int i = 2; i <= 4; i++) rightColumn.add(new Pair<>(i, 6));
//      {22, 30, 38, 46};
        for (Pair<Integer, Integer> square : leftColumn) {
            here = myBoard[square.fst][square.snd];
            up = myBoard[square.fst + 1][square.snd];
            down = myBoard[square.fst - 1][square.snd];
            if (here == -color && up == 0)
                potentialMobility++;
            if (here == -color && down == 0)
                potentialMobility++;
        }

        return potentialMobility;
    }
}
