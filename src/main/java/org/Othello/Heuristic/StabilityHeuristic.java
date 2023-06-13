package org.Othello.Heuristic;


import org.Othello.Board.Board;

public class StabilityHeuristic
{
    int[][] stabilityWeights = {
            {4, -3, 2,  2,  2, 2, -3, 4},
            {-3, -4, -1,  -1,  -1, -1, -4, -3},
            {2, -1,  1,  0,  0,  1, -1, 2},
            {2,  -1,  0, 1, 1,  0,  -1, 2},
            {2,  -1,  0, 1, 1,  0,  -1, 2},
            {2, -1,  1,  0,  0,  1, -1, 2},
            {-3, -4, -1,  -1,  -1, -1, -4, -3},
            {4, -3, 2,  2,  2, 2, -3, 4}
    };

    public StabilityHeuristic() {
    }

    public int getScore(Board currentBoard , int player)
    {
        int heuristicScore = 0;
        int[][] board = currentBoard.getBoard();

        for (int row = 0; row < currentBoard.getRow(); row++) {
            for (int col = 0; col < currentBoard.getColumn(); col++) {
                if (board[row][col] == player) {
                    heuristicScore += stabilityWeights[row][col];
                }
            }
        }

        return heuristicScore;
}
}