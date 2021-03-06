package sokoban.model.items;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sokoban.model.util.Direction;
import sokoban.model.util.Pair;

import java.util.Objects;

/**
 * Created by eugeny on 18.01.2016.
 * Sokoban FX example
 */
public abstract class GameObject {
    private Pair position;

    public GameObject(int row, int column) {
        position = new Pair(row, column);
    }

    public abstract Color getColor();

    public Color getDefaultColor() {
        return Color.BLACK;
    }

    public Image getImage() {
        return null;
    }

    public int getRow() {
        return position.getRow();
    }

    public int getColumn() {
        return position.getColumn();
    }

    public boolean move(Direction dir) {
        if (this instanceof Movable) {
            position = dir.nextXY(position);
            return true;
        } else {
            return false;
        }
    }

    public Pair getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameObject)) return false;
        GameObject that = (GameObject) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
