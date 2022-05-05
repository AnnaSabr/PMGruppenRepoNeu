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
public abstract class Monster extends Figuren {

    private Level currentLevel;
    private Animation idleAnimation;
    private float geschwindigkeit;
    private int lebenspunkte;
    private int staerke;
    private List<String> animation;
    private List<String> rechts;
    private List<String> links;
    private int time;


    public Monster( int lebenspunkte,int staerke, float geschwindigkeit, Painter painter, SpriteBatch batch) {
        super(lebenspunkte,staerke,geschwindigkeit,painter, batch);
        this.staerke= staerke;
        this.geschwindigkeit=geschwindigkeit;
        this.lebenspunkte=lebenspunkte;
        rechts = new ArrayList<>();
        links = new ArrayList<>();
        animation = new ArrayList<>();
        time = 0;
        idleAnimation = new Animation(animation, 5);
    }


    @Override
    public void update() {
        Point newPosition = new Point(getPosition());
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
                setPosition(newPosition);
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

    /**
     *
     * @param level ist das aktuelle Level
     */
    public void setLevel(Level level) {
        currentLevel = level;
        setPosition(level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint());
    }

    @Override
    public Animation getActiveAnimation() {
        return idleAnimation;
    }
}
