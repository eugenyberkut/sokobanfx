package sokoban.model;


/**
 * Created by Yevhen Berkunskyi on 10.01.2016.
 * Demo for OOP
 */
public class Level {
    private final int sizeX;
    private final int sizeY;
    private final int length;
    private final char[][] data;
    private final int num;
    private Maze storedMaze;

    public Level(int num, int sizeX, int sizeY, int length, char[][] data) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.length = length;
        this.data = data;
        this.num = num;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getNum() {
        return num;
    }

    public int getLength() {
        return length;
    }
//
//    public char[][] getData() {
//        return data;
//    }

    public Level getNext() {
        return Levels.getLevel(num + 1);
    }

    public Maze buildMaze() {
        Maze maze = new Maze();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                switch (data[i][j]) {
                    case 'X':
                        maze.getBorders().add(new Border(i, j));
                        break;
                    case '*':
                        maze.getBoxes().add(new Box(i, j));
                        break;
                    case '.':
                        maze.getTargets().add(new Target(i, j));
                        break;
                    case '&':
                        maze.getBoxes().add(new Box(i, j));
                        maze.getTargets().add(new Target(i, j));
                        break;
                    case '@':
                        maze.setMan(new Man(i, j));
                }
            }
        }
        maze.setSizes(getSizeX(), getSizeY());
        storedMaze = maze;
        return maze;
    }

    public Maze getStoredMaze() {
        return storedMaze;
    }
}
