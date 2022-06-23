package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;

public class Key extends Items{

    String texturePath;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Key(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath="character/items/genericItem_color_155.png";
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }

    public boolean removable(){
        return taken;
    }

    public void setLevel(Level level) {
        Level currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }
}
