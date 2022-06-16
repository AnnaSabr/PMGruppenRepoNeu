package desktop;

import basiselements.HUDElement;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.HUDPainter;
import tools.Point;

public class InventarUI extends HUDElement {

    /**
     * A object that can be controlled by the <code>HUDController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public InventarUI(HUDPainter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath="character/items/Store.png";
        position = new Point(300,300);
    }

    String texturePath;
    Point position;
    boolean invisible = true;

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getTexturePath() {
        return null;
    }

    @Override
    public boolean removable() {
        return this.invisible;
    }
}
