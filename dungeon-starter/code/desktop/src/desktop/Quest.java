package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;


public abstract class Quest extends Entity {

    Items taskItem;
    Items rewardItem;
    boolean erfuellt=false;

    /**
     * Quest kann angenommen werden, wenn es noch nicht angenommen wurde
     */
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
