package sokoban.model.items;

import javafx.scene.paint.Color;

/**
 * Created by eugeny on 18.01.2016.
 * Sokoban FX example
 */
public class Target extends GameObject {
    private final static Color color = new Color(1.0, 1.0, 0.0, 1.0);

    public Target(int row, int column) {
        super(row, column);
    }

    @Override
    public Color getColor() {
        return color;
    }
}
