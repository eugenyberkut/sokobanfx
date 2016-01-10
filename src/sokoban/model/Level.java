package sokoban.model;

import java.util.List;

/**
 * Created by Yevhen on 10.01.2016.
 */
public class Level {
    private final int sizeX;
    private final int sizeY;
    private final int length;
    private final char[][] data;

    public Level(int sizeX, int sizeY, int length, char[][] data) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.length = length;
        this.data = data;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getLength() {
        return length;
    }

    public char[][] getData() {
        return data;
    }
}
