package org.Othello.Board;
import java.util.ArrayList;
import java.util.List;

public class Moves extends Rectangle {
    Grid g ;
    int mn;

    @Override
    public Coordinates getPosition() {
        return position;
    }

//    public void setPosition(Coordinates position) {
//        this.position = position;
//    }

    private Coordinates position;
    static GridCell [][] grid;
    public Moves(Grid gr){
        this.g = gr;
        mn=g.getMoveNumber();
        grid=gr.getGrid();

    }

    private static List<Coordinates> validMoves = new ArrayList<>();
    public static Board makeMove(Board board, Coordinates coordinates, int playerNumber) {
        int[][] currentBoard = board.getBoard();
        // coordinates next move
        int row = coordinates.getxCoordinates();
        int col = coordinates.getyCoordinates();
        if (currentBoard[row][col] != 0) {
            // tb2a keda mamleya da for checking en next move de fadya
            return board;
        }

        currentBoard[row][col] = playerNumber;
        //haghyar el positions
        List<Coordinates> changedPositions = getChangedPositionsForMove(coordinates, playerNumber);
        for (Coordinates changedPosition : changedPositions) {
            currentBoard[changedPosition.getxCoordinates()][changedPosition.getyCoordinates()] = playerNumber;
        }

        //new one not override the current one
        return new Board(currentBoard);
    }

    public static List<Coordinates> getAvailableMoves(Board board , int playerNumber)
    {
        List<Coordinates> availableMoves=new ArrayList<>();
        int [][] gameBoard= board.getBoard();
        int size =board.getSize();
        //To be implemented

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (gameBoard[x][y]== 0 && isValidMove(new Coordinates(x,y))) {
                    availableMoves.add(new Coordinates(x, y));
                }
            }
        }

        return availableMoves;
    }


    /**
     * Plays the move and swaps all adjacent cells that should be swapped.
     * Then updates the valid move list to match the opposite player.
     *
     * @param position Grid position to play the move at.
     * @param player The player ID of the player who is placing their piece.
     */
    public void playMove(Coordinates position, int player) {
        mn++;
        g.setMoveNumber(mn);
        grid[position.getxCoordinates()][position.getyCoordinates()].setCellState(player);
        List<Coordinates> changeCellPositions = getChangedPositionsForMove(position, player);
        for(Coordinates swapPosition : changeCellPositions) {
            grid[swapPosition.getxCoordinates()][swapPosition.getyCoordinates()].setCellState(player);
        }
        updateValidMoves(player == 1 ? 2 : 1);
    }

    /**
     * Forces all the GridCells to reset back to their default state.
     */
    public void reset() {
        for(int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                grid[x][y].reset();
            }
        }
        g.setMoveNumber(0);
        updateValidMoves(1);
    }
    /**
     * Searches the grid to find all currently valid moves.
     *
     * @return A list containing all valid moves.
     */
    public static List<Coordinates> getAllValidMoves() {

        return validMoves;
    }

    /**
     * Converts the mouse position to a valid position inside the grid.
     *
     * @param mousePosition Position of the mouse in the panel.
     * @return The grid position where the mouse has clicked or a position with -1,-1 if it was invalid,
     */
    public Coordinates convertMouseToGridPosition(Coordinates mousePosition) {
        int gridX = (mousePosition.getxCoordinates()- position.getxCoordinates())/grid[0][0].width;
        int gridY = (mousePosition.getyCoordinates()- position.getyCoordinates())/grid[0][0].height;
        if(gridX >= grid.length || gridX < 0 || gridY >= grid[0].length || gridY < 0) {
            return new Coordinates(-1,-1);
        }
        return new Coordinates(gridX,gridY);
    }

    /**
     * Checks if the position specified is in the valid move list.
     *
     * @param position Grid position to verify if it is in the valid move list.
     * @return True if the position can be played as a valid move by the current player.
     */
    public static boolean  isValidMove(Coordinates position) {
        return getAllValidMoves().contains(position);
    }

    /**
     * Counts all the 0s,1s, and 2s on the grid and reports a winner if there is one.
     *
     * @param stillValidMoves If false, ignore 0s and choose a winner.
     * @return 0 for no winner, 3 for draw, 1 for player 1, and 2 for player 2.
     */
    public int getWinner(boolean stillValidMoves) {
        int[] counts = new int[3];
        for(int y = 0; y < grid[0].length; y++) {
            for(int x = 0; x < grid.length; x++) {
                counts[grid[x][y].getCellState()]++;
            }
        }

        if(stillValidMoves && counts[0] > 0) return 0;
        else if(counts[1] == counts[2]) return 3;
        else return counts[1] > counts[2] ? 1 : 2;
    }

    /**
     * Updates the list of valid moves based on the current game state.
     * Leaves only the current moves highlighted.
     *
     * @param playerID The current player to update the move list with.
     */
    public void updateValidMoves(int playerID) {
        // Remove all highlighted elements so they are not valid moves visually
        for(Coordinates validMove : validMoves) {
            grid[validMove.getxCoordinates()][validMove.getyCoordinates()].setHighlight(false);
        }
        validMoves.clear();
        // When in the first 4 turns only the middle 4 cells can be played.
        if(g.getMoveNumber() < 4) {
            int midX = grid.length/2-1;
            int midY = grid[0].length/2-1;
            for (int x = midX; x < midX+2; x++) {
                for (int y = midY; y < midY+2; y++) {
                    if (grid[x][y].getCellState() == 0) {
                        validMoves.add(new Coordinates(x, y));
                    }
                }
            }
        } else {
            // Otherwise find valid moves for the current player that change adjacent pieces
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    if (grid[x][y].getCellState() == 0 && getChangedPositionsForMove(new Coordinates(x,y),playerID).size()>0) {
                        validMoves.add(new Coordinates(x, y));
                    }
                }
            }
        }
        // Visually update all valid move positions to show with a highlight
        for(Coordinates validMove : validMoves) {
            grid[validMove.getxCoordinates()][validMove.getyCoordinates()].setHighlight(true);
        }
    }

    /**
     * Checks for all changed cell positions based on playing the specified move.
     * Will be an empty list if move is invalid.
     *
     * @param position Grid position to check outward from.
     * @param playerID Current player to test with.
     * @return A list of all positions that were changed from playing at move at the specified position.
     */
    public static List<Coordinates> getChangedPositionsForMove(Coordinates position, int playerID) {
        List<Coordinates> result = new ArrayList<>();
        result.addAll(getChangedPositionsForMoveInDirection(position, playerID, Coordinates.DOWN));
        result.addAll(getChangedPositionsForMoveInDirection(position, playerID, Coordinates.LEFT));
        result.addAll(getChangedPositionsForMoveInDirection(position, playerID, Coordinates.UP));
        result.addAll(getChangedPositionsForMoveInDirection(position, playerID, Coordinates.RIGHT));
        return result;
    }
    /**
     * Tests for a single given direction finding all cells that would be changed from the given position.
     *
     * @param position Grid position to check outward from.
     * @param playerID Current player to test with.
     * @param direction Direction of motion to test in.
     * @return A list of all positions that were changed in the given direction if the position was played as a move.
     */
    private static List<Coordinates> getChangedPositionsForMoveInDirection(Coordinates position, int playerID, Coordinates direction) {
        List<Coordinates> result = new ArrayList<>();
        Coordinates movingPos = new Coordinates(position);
        int otherPlayer = playerID == 1 ? 2 : 1;
        movingPos.add(direction);
        // Keep moving while there are positions that would be changed.
        while(inBounds(movingPos) && grid[movingPos.getxCoordinates()][movingPos.getyCoordinates()].getCellState() == otherPlayer) {
            result.add(new Coordinates(movingPos));
            movingPos.add(direction);
        }
        // If the end position is off the board, or the end playerID does not match the player, that
        // means that the move would not give any valid swaps in this direction.
        if(!inBounds(movingPos) || grid[movingPos.getxCoordinates()][movingPos.getyCoordinates()].getCellState() != playerID) {
            result.clear();
        }
        return result;
    }

    /**
     * Test a given grid position if it is valid.
     *
     * @param position Grid position to test if valid.
     * @return True if the grid position is on the grid.
     */
    private static boolean inBounds(Coordinates position) {
        return !(position.getxCoordinates() < 0 || position.getyCoordinates() < 0 || position.getxCoordinates() >= grid.length || position.getyCoordinates() >= grid[0].length);
    }
}


