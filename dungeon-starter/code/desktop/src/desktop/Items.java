package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;

public abstract class Items extends Entity {
    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Items(Painter painter, SpriteBatch batch) {
        super(painter, batch);
    }

    public void setLevel(Level currentLevel) {
    }
}
