package sokoban.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Yevhen on 09.01.2016.
 */
public class GameView {

    private final Canvas canvas;

    public GameView(Canvas canvas) {
        this.canvas = canvas;
    }

    public void draw() {
        clear();
        drawField();
    }

    private void drawField() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.strokeLine(0,0,canvas.getWidth(),canvas.getHeight());
        gc.strokeLine(canvas.getWidth(),0,0,canvas.getHeight());
    }

    private void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }
}
