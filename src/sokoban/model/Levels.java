package sokoban.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/**
 * Created by Yevhen on 09.01.2016.
 */
public class Levels {
    private static List<String> lines;

    public static List<String> getLines() {
        return lines;
    }

    static {
        try {
            lines = Files.newBufferedReader(Paths.get("soko.txt")).lines().collect(toCollection(ArrayList<String>::new));
            Logger.getLogger(sokoban.model.Levels.class.getName()).log(java.util.logging.Level.INFO, "Ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getTotal() {
        return Integer.valueOf(lines.get(0).split(": ")[1]);
    }

    public static Level getLevel(int level) {
        if (level<1 || level>getTotal()) {
            throw new IndexOutOfBoundsException("Level must be in [1,60], but is " + level);
        }
        int pos=0;
        String pattern = "Maze: " + level;
        while (!lines.get(pos).startsWith(pattern)) pos++;
        int sizeX = Integer.parseInt(lines.get(pos+1).split(": ")[1]);
        int sizeY = Integer.parseInt(lines.get(pos+2).split(": ")[1]);
        int length = Integer.parseInt(lines.get(pos+3).split(": ")[1]);
        List<String> strings = lines.subList(pos + 5, pos + 5 + sizeY);
        char[][] data = new char[sizeY][sizeX];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = strings.get(i).length() <= j ? ' ' : strings.get(i).charAt(j);
            }
        }
        return new Level(sizeX, sizeY, length, data);
    }
}
