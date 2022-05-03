package desktop;

import basiselements.Animatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Oberklasse der Monster
 *
 * enthaelt alle allgemein gueltigen Funktionen fuer jegliche Art Monster
 */
public abstract class Monster extends Animatable {
    private Point position;
    private Level currentLevel;
    private Animation idleAnimation;
    private float geschwindigkeit;
    private int lebenspunkte;
    private int staerke;
    private List<String> animation;
    private List<String> rechts;
    private List<String> links;
    private int time;


    public Monster(int staerke, float geschwindigkeit, int lebenspunkte, Painter painter, SpriteBatch batch) {
        super(painter, batch);
        this.staerke= staerke;
        this.geschwindigkeit=geschwindigkeit;
        this.lebenspunkte=lebenspunkte;
        rechts = new ArrayList<>();
        links = new ArrayList<>();
        animation = new ArrayList<>();
        time = 0;
        idleAnimation = new Animation(animation, 5);
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
    public void update() {
        Point newPosition = new Point(this.position);
        float movementSpeed = 0.3f;
        Random ran = new Random();
        if (time % 10 == 0) {
            int r = ran.nextInt(4);
            if (r == 0) {
                newPosition.y += movementSpeed;
            }
            if (r == 1) {
                newPosition.x -= movementSpeed;
            }
            if (r == 2) {
                newPosition.x += movementSpeed;
            }
            if (r == 3) {
                newPosition.y -= movementSpeed;
            }
            if (currentLevel.getTileAt(newPosition.toCoordinate()).isAccessible()) {
                this.position = newPosition;
                if (r == 1 | r == 2) {
                    idleAnimation = new Animation(links, 5);
                }
                if (r == 0 | r == 3) {
                    idleAnimation = new Animation(rechts, 5);
                }
            }
        }
        time++;
    }


    @Override
    public Animation getActiveAnimation() {
        return idleAnimation;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    /**
     *
     * @return IDLEAnimation
     */
    public List<String> getAnimation() {
        return animation;
    }

    /**
     *
     * @return Animation bei nach Links laufen
     */
    public List<String> getLinks() {
        return links;
    }

    /**
     *
     * @return Animatin bei nach rechts laufen
     */
    public List<String> getRechts() {
        return rechts;
    }
}
