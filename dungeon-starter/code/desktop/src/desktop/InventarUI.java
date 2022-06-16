package desktop;

import basiselements.HUDElement;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.HUDPainter;
import level.elements.Level;
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
        position = new Point(0,0);
        this.drawWithScaling(100,500);
    }

    /**
     *  bestimmt die Position im aktuellen Level
     * @param level ist das aktuelle Level
     */
    public void setLevel(Level level) {
        currentLevel = level;
        //position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    /**
     *
     * @return das aktuelle Level
     */
    public Level getLevel(){
        return this.currentLevel;
    }

    private Level currentLevel;
    String texturePath;
    Point position;
    boolean invisible = false;

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }

    @Override
    public boolean removable() {
        return this.invisible;
    }
}
