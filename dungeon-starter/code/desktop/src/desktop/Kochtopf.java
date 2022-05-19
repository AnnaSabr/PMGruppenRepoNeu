package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

public class Kochtopf extends Items{

    Point position;
    String texturePath;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Kochtopf(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        this.texturePath="character/items/topf.png";
    }

    public void setLevel(Level level) {
        Level currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    public boolean removable() {
        return taken;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
