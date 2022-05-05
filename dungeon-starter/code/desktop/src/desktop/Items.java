package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

public abstract class Items extends Entity {
    Point position;

    boolean taken;
    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Items(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        this.taken=false;
    }
    @Override
    public Point getPosition() {
        return position;
    }

    public void setLevel(Level currentLevel) {
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

}
