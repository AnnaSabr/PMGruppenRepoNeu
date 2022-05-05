package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;

public abstract class Weapon extends Items{


    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Weapon(Painter painter, SpriteBatch batch) {
        super(painter, batch);
    }
}
