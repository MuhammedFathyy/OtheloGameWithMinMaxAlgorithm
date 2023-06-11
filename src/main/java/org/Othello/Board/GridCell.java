
package org.Othello.Board;

import java.awt.Color;
import java.awt.Graphics;

public class GridCell extends Rectangle {
    private int cellState;
    private boolean highlight;

    public GridCell(Position position, int width, int height) {
        super(position, width, height);
        this.reset();
    }

    public void reset() {
        this.cellState = 0;
        this.highlight = false;
    }

    public void setCellState(int newState) {
        this.cellState = newState;
    }

    public int getCellState() {
        return this.cellState;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public void paint(Graphics g) {
        if (this.highlight) {
            g.setColor(new Color(255, 187, 22, 203));
            g.fillRect(this.position.x, this.position.y, this.width, this.height);
        }

        if (this.cellState != 0) {
            g.setColor(this.cellState == 1 ? Color.BLACK : Color.WHITE);
            g.fillOval(this.position.x, this.position.y, this.width, this.height);
        }
    }
}

