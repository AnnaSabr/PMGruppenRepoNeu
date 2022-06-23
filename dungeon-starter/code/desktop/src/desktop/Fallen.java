package desktop;

import basiselements.Animatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Oberklasse der Fallen
 *
 * enthaelt alle allgemein gueltigen Funktionne, die auf alle Fallen Arten zutreffen
 */
public abstract class Fallen extends Animatable {
    private Point position;
    private Level currentLevel;
    private Animation idleAnimation;
    private List<String> animation;
    private List<String> action;


    public Fallen(Painter painter, SpriteBatch batch){
        super(painter, batch);

        animation = new ArrayList<>();
        idleAnimation = new Animation(animation, 5);
        action = new ArrayList<>();
    }

    /**
     *  bestimmt die Position im aktuellen Level
     * @param level ist das aktuelle Level
     */
    public void setLevel(Level level) {
        currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public Animation getActiveAnimation() {
        return idleAnimation;
    }

    /**
     *
     * @return gibt die Basis IDLEAnimation zurueck
     */
    public List<String> getAnimation() {
        return animation;
    }

    /**
     *
     * @return Animation nach ausloesen der Falle
     */
    public List<String> getAction() {
        return action;
    }

    /**
     * setzt die gewuenschte IdleAnimation
     * @param idleAnimation
     */
    public void setIdleAnimation(Animation idleAnimation) {
        this.idleAnimation = idleAnimation;
    }


    /**
     * definiert in den Unterklasssen die Fallen Art spezifischen Effekte beim ausloesen
     * @param f entsprechende Figur (Monster oder Hero, auf die der Effekt angewendet werden soll
     */
    public abstract void effekte(Figuren f);

}
