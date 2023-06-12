
package org.Othello.Board;


import java.util.Collections;

public class SimpleAI {
    private Grid gameGrid;
    private Moves moves;
    public SimpleAI(Grid gameGrid) {
        this.gameGrid = gameGrid;
    }

    public Coordinates chooseMove() {
        Collections.shuffle(this.moves.getAllValidMoves());
        return (Coordinates)this.moves.getAllValidMoves().get(0);
    }
}
