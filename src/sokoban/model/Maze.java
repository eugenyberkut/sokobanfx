package sokoban.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by eugeny on 18.01.2016.
 * Sokoban FX example
 */
public class Maze {
    private List<GameObject> borders;
    private List<GameObject> targets;
    private List<GameObject> boxes;
    private Man man;

    public Maze() {
        borders = new ArrayList<>();
        targets = new ArrayList<>();
        boxes = new ArrayList<>();
    }

    public List<GameObject> getBorders() {
        return borders;
    }

    public List<GameObject> getTargets() {
        return targets;
    }

    public List<GameObject> getBoxes() {
        return boxes;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public void move(Direction dir) {
        if (!borders.stream().anyMatch(b -> b.getPosition().equals(dir.nextXY(man.getPosition())))) {
            if (!boxes.stream().anyMatch(b -> b.getPosition().equals(dir.nextXY(man.getPosition())))) {
                man.move(dir);
            } else {
                Box box = (Box) boxes.stream().filter(b -> b.getPosition().equals(dir.nextXY(man.getPosition()))).findFirst().get();
                if (!Stream.concat(boxes.stream(), borders.stream()).anyMatch(b -> b.getPosition().equals(dir.nextXY(box.getPosition())))) {
                    man.move(dir);
                    box.move(dir);
                }
            }
        }
    }

    public boolean isLevelCompleted() {
        return boxes.containsAll(targets);
    }
}
