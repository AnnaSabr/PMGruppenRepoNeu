package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import tools.Point;

public class Axe extends Weapon{

    public String name="Axt";
    String texturePath;
    Point position;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Axe(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath="character/items/weapon_axe.png";
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
