package sokoban.model;

import java.util.Objects;

/**
 * Created by eugeny on 18.01.2016.
 * Sokoban FX example
 */
public class Pair {
    private int row;
    private int column;

    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return row == pair.row &&
                column == pair.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
