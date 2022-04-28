package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import level.tools.Coordinate;
import tools.Point;

public class SpeedPotion extends Potion{

    public static int PotionsTaken = 0;

    String texturePath;
    Point position;
    public static float SpeedIncrease = PotionsTaken*0.2f;
    private Point point ;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public SpeedPotion(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath = "character/items/flask_big_blue.png";
    }

    public void setLevel(Level level) {
        Level currentLevel = level;
        position=level.getStartTile().getCoordinate().toPoint();

    }

    @Override
    public void usePotion() {

        PotionsTaken++;

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
