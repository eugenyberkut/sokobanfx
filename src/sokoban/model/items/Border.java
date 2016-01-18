package sokoban.model.items;

import javafx.scene.paint.Color;

/**
 * Created by eugeny on 18.01.2016.
 * Sokoban FX example
 */
public class Border extends GameObject {
    public Border(int row, int column) {
        super(row, column);
    }

    @Override
    public Color getColor() {
        return getDefaultColor();
    }
}
