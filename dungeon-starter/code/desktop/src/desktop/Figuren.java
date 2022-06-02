package desktop;

import basiselements.Animatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class Figuren extends Animatable {
    private Point position;
    private Level currentLevel;

    private int lebenspunkte;
    private int staerke;
    private float geschwindigkeit;

    private Animation idleAnimation;
    private List<String> animation;
    private List<String> rechts;
    private List<String> links;

    private int time;



    public Figuren(int lebenspunkte, int staerke, float geschwindigkeit,Painter painter, SpriteBatch batch){
        super(painter,batch);
        this.lebenspunkte=lebenspunkte;
        this.staerke=staerke;
        this.geschwindigkeit=geschwindigkeit;

        animation= new ArrayList<>();
        links = new ArrayList<>();
        rechts = new ArrayList<>();
        idleAnimation= new Animation(animation,5);

        time=0;

    }

    /**
     *  bestimmt die Position im aktuellen Level
     * @param level ist das aktuelle Level
     */
    public void setLevel(Level level) {
        currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    public Level getLevel(){
        return this.currentLevel;
    }


    @Override
    public Animation getActiveAnimation() {
        return idleAnimation;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    public void setPosition(Point po){
        this.position=po;
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

    public int getLebenspunkte(){
        return lebenspunkte;
    }

    public void setLebenspunkte(int abzug){
        this.lebenspunkte=lebenspunkte-abzug;
    }

    @Override
    public boolean removable(){
        boolean dead=false;
        if (lebenspunkte==0){
            dead=true;
            return dead;
        }
        return dead;
    }
    public void setIdleAnimation(Animation idleAnimation) {
        this.idleAnimation = idleAnimation;
    }


    public int getTime() {
        return time;
    }
    public void setTime(int tm){
        this.time=tm;
    }

    public void setRechts(List<String> rechts){
        this.rechts=rechts;
    }

    public void setLinks(List<String> links){
        this.links=links;
    }

    public void setAnimation(List<String> animation){
        this.animation=animation;
    }
}
