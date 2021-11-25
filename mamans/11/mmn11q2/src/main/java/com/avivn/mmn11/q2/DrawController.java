package com.avivn.mmn11.q2;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class DrawController {
    // constant for the number of shapes to generate on each click
    final int N_SHAPES_TO_GEN = 10;

    // The drawing destination
    @FXML
    private Canvas canvas;

    // The random number generator - no need to create again and again
    private final Random generator;

    public DrawController() {
        generator = new Random();
    }

    @FXML
    // triggers when clicking the button to draw, and draws 10 random shapes.
    protected void onDrawButtonClick() {
        // remove all existing drawings first
        canvas.getGraphicsContext2D()
                .clearRect(0,0,canvas.getWidth(), canvas.getHeight());
        // draw N_SHAPES_TO_GEN random shapes
        for (int i = 0; i < N_SHAPES_TO_GEN; i++) {
            drawRandomShape();
        }
    }

    // Draws a single random shape
    private void drawRandomShape() {
        GraphicsContext graphics = canvas.getGraphicsContext2D();

        // generate y/x positions & sizes (at most 25% of the height/width)
        double xPos = generator.nextDouble(0, canvas.getWidth());
        double yPos = generator.nextDouble(0, canvas.getHeight());

        double width = generator.nextDouble(1, canvas.getWidth() / 4);
        double height = generator.nextDouble(1, canvas.getHeight() / 4);

        // generate a random color (random RGB 0-1 scales in the color constructor)
        graphics.setStroke(Color.color(
                generator.nextDouble(),
                generator.nextDouble(),
                generator.nextDouble()));

        // pick a random shape - switch random 0/1/2
        switch (generator.nextInt(3)) {
            case 0 -> graphics.strokeOval(xPos, yPos, width, height);
            case 1 -> graphics.strokeLine(xPos, yPos, width, height);
            case 2 -> graphics.strokeRect(xPos, yPos, width, height);
        }
    }
}