package desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import level.elements.room.Tile;
import level.tools.Coordinate;
import tools.Point;

import java.util.List;

public class SpeedPotion extends Potion{


    //public static int PotionsTaken = 0;

    String texturePath;
    Point position;
    public static float SpeedIncrease = 0.0f;
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
        //position=level.getStartTile().getCoordinate().toPoint();
        //Coordinate c = new Coordinate(-1,0);
        //position=c.toPoint();
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    /** Item wird verwendet, keine Wirkung, wenn Geschwindigkeit
     *  des Helden 0.3 beträgt
     */
    @Override
    public void usePotion() {

        if(SpeedIncrease<0.2){
            SpeedIncrease=SpeedIncrease+0.02f;
        }

    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }

    public boolean removable() {
        float x = MyHero.position.x;
        float y = MyHero.position.y;

        int coordx = (int) getPosition().x;
        int coordy = (int) getPosition().y;

        if(x>coordx-1&&x<coordx+1) {
            if (y > coordy - 1 && y < coordy + 1) {
                if(Gdx.input.isKeyPressed(Input.Keys.E)){
                    usePotion();
                    return true;
                }
            }
        }
        return false;
    }
}
