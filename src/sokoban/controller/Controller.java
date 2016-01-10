package sokoban.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import sokoban.model.Levels;
import sokoban.view.GameView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private int totalLevels = Levels.getTotal();
    private GameView gv;

    @FXML
    Canvas canvas;

    @FXML
    Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        canvas.widthProperty().addListener(evt -> gv.draw());
        canvas.heightProperty().addListener(evt -> gv.draw());
        System.out.println(">>> " + totalLevels);
        gv = new GameView(canvas);
    }


}
