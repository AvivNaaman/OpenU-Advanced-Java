package avivn.mmn12.q2;

import java.util.Random;

/**
 * A class that implements an instance of Conway's Game of Life.
 */
public class GameOfLife {
    // holds the data
    private boolean[][] dataMatrix;
    // holds the data matrix shape (for easy & reliable access)
    private final int dataHeight;
    private final int dataWidth;

    /**
     * Constructs a new empty game of life model, for the specified dimensions
     *
     * @param matHeight The number of rows (y)
     * @param matWidth  The number of columns (x)
     */
    public GameOfLife(int matHeight, int matWidth) {
        dataHeight = matHeight;
        dataWidth = matWidth;
        // empty at first
        this.dataMatrix = new boolean[dataHeight][dataWidth];
    }

    /**
     * Calculates the next generation for the current data matrix,
     * And saves it back into that matrix.
     */
    public void nextGen() {
        // we need a new matrix - writing directly to the old one will make the code wrong.
        boolean[][] nextGen = new boolean[dataHeight][dataWidth];
        // for each cell
        for (int i = 0; i < dataHeight; i++) {
            for (int j = 0; j < dataWidth; j++) {
                // count neighbors and set state
                int neighborsNum = countNeighbors(i, j);
                if (neighborsNum <= 1 || neighborsNum >= 4) { // death (lone/explosion)
                    nextGen[i][j] = false;
                } else if (neighborsNum == 3) { // born
                    nextGen[i][j] = true;
                } else { // keep
                    nextGen[i][j] = dataMatrix[i][j];
                }
            }
        }
        // update to the new matrix
        dataMatrix = nextGen;
    }


    // Counts the neighbors for the current cell in the current data matrix.
    private int countNeighbors(int row, int col) {
        // [V][V][V]
        // [V][X][V]
        // [V][V][V]
        // maxes & mins - to avoid IndexOutOfBounds exception
        int count = 0;
        for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, dataHeight - 1); i++) { // rows
            for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, dataWidth - 1); j++) { // cols
                if (i != row || j != col) { // not current cell
                    count += dataMatrix[i][j] ? 1 : 0; // increment if alive
                }
            }
        }
        return count;
    }

    /**
     * Generates a random data for the data matrix.
     */
    public void randomGen() {
        final int RANDOM_BOUND = 2; // probability for a living cell is 1/RANDOM_BOUND
        Random generator = new Random();
        // randomize for each cell it's alive value by the generator's result
        for (int i = 0; i < dataHeight; i++) {
            for (int j = 0; j < dataWidth; j++) {
                // only on 0, check cell as alive
                if (generator.nextInt(RANDOM_BOUND) == 0) {
                    dataMatrix[i][j] = true;
                }
            }
        }
    }

    /**
     * Returns whether the specified cell in the specified coordinates is alive.
     *
     * @param row The row (y) of the cell
     * @param col The col (x) of the cell
     * @return Whether the cell at [row][col] is alive.
     */
    public boolean isAlive(int row, int col) {
        return dataMatrix[row][col];
    }
}
