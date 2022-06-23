package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

public abstract class Items extends Entity {
    Point position;
    private Level currentLevel;

    String nameTyp;
    boolean taken;
    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Items(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        this.taken=false;
    }
    @Override
    public Point getPosition() {
        return position;
    }

    /**
     *
     * @param level bestimmt das aktuelle Level
     */
    public void setLevel(Level level) {
        currentLevel = level;
    }

    /**
     *
     * @return gibt das aktuelle Level aus
     */
    public Level getLevel(){
        return this.currentLevel;
    }

    /**
     *
     * @param po setzt eine neue Position
     */
    public void setPosition(Point po){
        this.position=po;
    }


    /**
     *
     * @return gibt an, dass das Item ausgeruestet ist
     */
    public boolean isTaken() {
        return taken;
    }

    /**
     *
     * @param taken
     */
    public void setTaken(boolean taken) {
        this.taken = taken;
    }

}
