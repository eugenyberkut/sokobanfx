package sokoban.model;

import javafx.scene.paint.Color;

/**
 * Created by eugeny on 18.01.2016.
 * Sokoban FX example
 */
public class Box extends GameObject implements Movable {
    private final static Color color = new Color(0.0, 0.0, 1.0, 0.5);

    public Box(int row, int column) {
        super(row, column);
    }

    @Override
    public Color getColor() {
        return color;
    }


}
