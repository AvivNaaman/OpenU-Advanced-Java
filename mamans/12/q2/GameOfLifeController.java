package avivn.mmn12.q2;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameOfLifeController {
    // constants for board row & col number
    final int BOARD_ROWS = 10, BOARD_COLS = 10;

    // to determine whether random initialization is required
    private boolean isZeroGen = true;
    // the data class
    private final GameOfLife gameEngine;

    @FXML
    // the board drawing canvas
    private Canvas canvas;

    // initialize board
    public GameOfLifeController() {
        gameEngine = new GameOfLife(BOARD_ROWS, BOARD_COLS);
    }

    @FXML
    // on first click generate random, otherwise calculate next generation
    protected void onNextGenClicked() {
        if (isZeroGen) {
            gameEngine.randomGen();
            isZeroGen = false;
        } else {
            gameEngine.nextGen();
        }
        // clear canvas - avoid table over stroking, update
        canvas.getGraphicsContext2D()
                .clearRect(0,0,canvas.getHeight(), canvas.getWidth());
        // draw living cells
        updateUi();
        // draw table outlines
        drawTable();
    }

    // Shades an alive square, Leaves a dead square
    private void updateUi() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.LIGHTGRAY);

        final double rowSpacing = canvas.getHeight() / BOARD_ROWS;
        final double colSpacing = canvas.getHeight() / BOARD_ROWS;
        double currentY = 0;
        for (int i = 0; i < BOARD_ROWS; i++) { // rows
            double currentX = 0;
            for (int j = 0; j < BOARD_COLS; j++) { // cols
                if (gameEngine.isAlive(i, j)) { // shade if alive
                    graphicsContext.fillRect(currentX, currentY, colSpacing, rowSpacing);
                }
                currentX += colSpacing;
            }
            currentY += rowSpacing;
        }
    }

    // Draws the table's lines
    private void drawTable() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setLineWidth(1);
        // draw rows
        final double rowSpacing = canvas.getHeight() / BOARD_ROWS;
        double rowY = rowSpacing;
        for (int i = 1; i < BOARD_ROWS; i++) {
            graphicsContext.strokeLine(0, rowY, canvas.getWidth(), rowY);
            rowY += rowSpacing;
        }
        // draw cols
        final double colSpacing = canvas.getHeight() / BOARD_ROWS;
        double colX = rowSpacing;
        for (int j = 1; j < BOARD_COLS; j++) {
            graphicsContext.strokeLine(colX, 0, colX, canvas.getHeight());
            colX += colSpacing;
        }
    }
}