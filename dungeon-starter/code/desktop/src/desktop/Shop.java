package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

public class Shop extends Entity {
    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Shop(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath="character/umgebung/gebaeude.png";
    }

    String texturePath;

    public void setLevel(Level level) {
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    Point position;
    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
