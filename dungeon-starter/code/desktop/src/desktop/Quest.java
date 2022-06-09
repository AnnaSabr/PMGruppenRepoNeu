package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

import java.util.Scanner;

public abstract class Quest extends Entity {

    public abstract void questVorschlagen();

    boolean accepted = false;
    Point position;
    public Point getPosition() {
        return position;
    }

    String questTask;

    String questReward;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Quest(Painter painter, SpriteBatch batch) {
        super(painter, batch);
    }


    public void setLevel(Level currentLevel) {
    }


}
