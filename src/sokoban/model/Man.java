package sokoban.model;

import javafx.scene.paint.Color;

/**
 * Created by eugeny on 18.01.2016.
 * Sokoban FX example
 */
public class Man extends GameObject implements Movable {
    public Man(int row, int column) {
        super(row, column);
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }


}
