package sokoban.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sokoban.model.Game;
import sokoban.model.items.GameObject;
import sokoban.model.items.Man;
import sokoban.model.util.Maze;

import java.util.List;

/**
 * Created by Yevhen on 09.01.2016.
 * Sokoban FX example
 */
public class GameView {

    private int CELL_SIZE = 25;

    private final Canvas canvas;
    private final Game game;

    public GameView(Canvas canvas, Game game) {
        this.canvas = canvas;
        this.game = game;
    }

    public void draw() {
        clear();
        int dx = (30 - game.getCurrentFieldSizeX()) / 2;
        int dy = (22 - game.getCurrentFieldSizeY()) / 2;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.translate(dx * CELL_SIZE, dy * CELL_SIZE);
        drawField();
        gc.translate(-dx * CELL_SIZE, -dy * CELL_SIZE);
    }

    private void drawField() {
        drawMaze(game.getMaze());
    }

    private void drawMaze(Maze maze) {
        if (maze == null) return;

        drawObjects(maze.getBorders());
        drawObjects(maze.getTargets());
        drawObjects(maze.getBoxes());
        drawGameObject(maze.getMan());
    }

    private void drawObjects(List<? extends GameObject> borders) {
        borders.stream().forEach(this::drawGameObject);
    }

    private void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }

    public void drawGameObject(GameObject go) {
        int y = go.getRow();
        int x = go.getColumn();
        if (go.getImage() != null) {
            canvas.getGraphicsContext2D().drawImage(go.getImage(), x * CELL_SIZE, y * CELL_SIZE);
        } else {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(go.getColor());
            gc.setStroke(Color.BLACK);
            if (go instanceof Man) {
                gc.fillOval(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                gc.strokeOval(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            } else {
                gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                gc.strokeRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }
}
