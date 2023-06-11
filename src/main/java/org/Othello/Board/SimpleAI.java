
package org.Othello.Board;


import java.util.Collections;

public class SimpleAI {
    private GameGrid gameGrid;

    public SimpleAI(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    public Position chooseMove() {
        Collections.shuffle(this.gameGrid.getAllValidMoves());
        return (Position)this.gameGrid.getAllValidMoves().get(0);
    }
}
