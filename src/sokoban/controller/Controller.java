package sokoban.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import sokoban.model.Direction;
import sokoban.model.Game;
import sokoban.view.GameView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {

    private GameView gv;
    private Game game;

    @FXML
    Canvas canvas;

    @FXML
    Pane pane;

    Logger LOG;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LOG = Logger.getLogger(this.getClass().getName());

        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        canvas.widthProperty().addListener(evt -> gv.draw());
        canvas.heightProperty().addListener(evt -> gv.draw());
        game = new Game();
        gv = new GameView(canvas, game);
        pane.requestFocus();
    }


    public void processKey(Event event) {

        KeyEvent keyEvent = (KeyEvent) event;
        KeyCode keyCode = keyEvent.getCode();
        LOG.log(Level.INFO, String.valueOf(keyCode));
        switch (keyCode) {
            case UP:
                game.move(Direction.UP);
                break;
            case DOWN:
                game.move(Direction.DOWN);
                break;
            case LEFT:
                game.move(Direction.LEFT);
                break;
            case RIGHT:
                game.move(Direction.RIGHT);
                break;
        }
        gv.draw();
    }
}
