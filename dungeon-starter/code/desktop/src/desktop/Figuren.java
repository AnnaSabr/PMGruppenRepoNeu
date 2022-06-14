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
 * alle Figuren aka Monster Hero NPC
 */
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
    private boolean dead;
    private int gesamtesLeben;



    public Figuren(int lebenspunkte, int staerke, float geschwindigkeit,Painter painter, SpriteBatch batch){
        super(painter,batch);
        this.lebenspunkte=lebenspunkte;
        this.staerke=staerke;
        this.geschwindigkeit=geschwindigkeit;
        this.gesamtesLeben=lebenspunkte;

        animation= new ArrayList<>();
        links = new ArrayList<>();
        rechts = new ArrayList<>();
        idleAnimation= new Animation(animation,5);

        time=0;
        dead=false;

    }

    /**
     *  bestimmt die Position im aktuellen Level
     * @param level ist das aktuelle Level
     */
    public void setLevel(Level level) {
        currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    /**
     *
     * @return das aktuelle Level
     */
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

    /**
     *
     * @param po legt die leue Positon der Figur fest
     */
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


    /**
     *
     * @return das Leben der Figur
     */
    public int getLebenspunkte(){
        return lebenspunkte;
    }

    /**
     *
     * @param abzug des Lebens der uebergebenen Punkte
     */
    public void setLebenspunkte(int abzug){
        this.lebenspunkte=lebenspunkte-abzug;
    }

    public void setLebenspunkteStart(int leben){
        this.lebenspunkte=leben;
    }
    @Override
    public boolean removable(){
       dead=false;
        if (lebenspunkte<=0){
            dead=true;
            return dead;
        }
        return dead;
    }

    /**
     *
     * @param idleAnimation aktuelle Animation der Figur
     */
    public void setIdleAnimation(Animation idleAnimation) {
        this.idleAnimation = idleAnimation;
    }

    /**
     *
     * @return time zum Zaehlen der Sekunden in Update
     */
    public int getTime() {
        return time;
    }

    /**
     *
     * @param tm setzt den timer auf eine uebergebene Zeit
     */
    public void setTime(int tm){
        this.time=tm;
    }

    /**
     *
     * @param rechts bestimtm die Liste der der Texturen fuer die Rechte Animation
     */
    public void setRechts(List<String> rechts){
        this.rechts=rechts;
    }

    /**
     *
     * @param links  bestimtm die Liste der der Texturen fuer die linke Animation
     */
    public void setLinks(List<String> links){
        this.links=links;
    }

    /**
     *
     * @param animation bestimmt die aktuelle animation
     */
    public void setAnimation(List<String> animation){
        this.animation=animation;
    }

    /**
     *
     * @return bestimmt, dass die Fugur tot ist
     */
    public boolean isDead() {
        return dead;
    }


    /**
     *
     * @return staerke der aktuellen Figur
     */
    public int getStaerke() {
        return staerke;
    }

    /**
     *
     * @param staerke legt die Staerke der aktuellen Figur fest
     */
    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    /**
     *
     * @return gibt die aktuelle Geschwindigkeit der Figur zurueck
     */
    public float getGeschwindigkeit() {
        return geschwindigkeit;
    }

    /**
     *
     * @param geschwindigkeit setzt diese bei der aktuellen Figur
     */
    public void setGeschwindigkeit(float geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    /**
     *
     * @return den Wert, den die Figur beim erstellen als Lebenspunkte uebergeben bekommen hat
     */
    public int getGesamtesLeben(){
        return gesamtesLeben;
    }
}
