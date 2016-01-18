package sokoban.model;

import java.util.logging.Logger;

/**
 * Created by eugeny on 18.01.2016.
 * Sokoban FX example
 */
public class Game {
    private int totalLevels = Levels.getTotal();
    private Level level;

    public Game() {
        level = Levels.getLevel(1);
        level.buildMaze();
    }

    public Maze getMaze() {
        return level.getStoredMaze();
    }

    public int getCurrentFieldSizeX() {
        return level.getSizeX();
    }

    public int getCurrentFieldSizeY() {
        return level.getSizeY();
    }

    public void move(Direction dir) {
        getMaze().move(dir);
        if (getMaze().isLevelCompleted()) {
            Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.INFO, "competed");
            nextLevel();
        }
    }

    private void nextLevel() {
        level = level.getNext();
        level.buildMaze();
        Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.INFO, "level=" + level.getNum() + " length=" + level.getLength());
    }
}
