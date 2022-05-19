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


    private Animation idleAnimation;
    private float geschwindigkeit;
    private int lebenspunkte;
    private int staerke;
    private List<String> animation;
    private List<String> rechts;
    private List<String> links;
    private int time;
    private MonsterBewegung bewegung;



    public Monster(MonsterBewegung bewegung, int lebenspunkte,int staerke, float geschwindigkeit, Painter painter, SpriteBatch batch) {
        super(lebenspunkte,staerke,geschwindigkeit,painter, batch);
        this.staerke= staerke;
        this.geschwindigkeit=geschwindigkeit;
        this.lebenspunkte=lebenspunkte;
        this.rechts = new ArrayList<>();
        this.links = new ArrayList<>();
        this.animation = new ArrayList<>();
        this.time = 0;
        this.idleAnimation = new Animation(animation, 5);
        this.bewegung=bewegung;
    }

    public void bewegen(){
        bewegung.bewegen(this);
    }


    @Override
    public void update() {
        if (time % 10 == 0) {
            bewegen();
        }
        time++;
    }

    @Override
    public Animation getActiveAnimation() {
        return idleAnimation;
    }

    public void setIdleAnimation(Animation idleAnimation) {
        this.idleAnimation = idleAnimation;
    }

    public List<String> getlinks(){
        return links;
    }

    public List<String> getNichtLinks(){
        return rechts;
    }
}
