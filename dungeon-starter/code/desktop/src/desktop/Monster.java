package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import tools.Point;

/**
 * Oberklasse der Monster
 *
 * enthaelt alle allgemein gueltigen Funktionen fuer jegliche Art Monster
 */
public abstract class Monster extends Figuren {

    private FigurenBewegung bewegung;



    public Monster(FigurenBewegung bewegung, int lebenspunkte, int staerke, float geschwindigkeit, Painter painter, SpriteBatch batch) {
        super(lebenspunkte,staerke,geschwindigkeit,painter, batch);
        this.bewegung=bewegung;
    }

    /**
     * ruft die entsprechende individuelle Bewegung der Figur auf
     */
    public void bewegen(){
        bewegung.bewegen(this);
    }


    @Override
    public void update() {

        if (getTime() % 10 == 0) {
            bewegen();
        }
        setTime(getTime()+1);
    }

    /**
     * bestimmt, was mit dem MOnster passiert, wenn es von einem Projektiel getroffen wird
     * @param richtung in welche Richtung das MOnster geschossenw erden soll
     */
    public void getroffen(EProjektile richtung){
        Point newPosition = new Point(getPosition());
        float stossWeite = 2.0f;
        if (richtung==EProjektile.NORD){
                newPosition.y+=stossWeite;}
        if (richtung==EProjektile.OST){
            newPosition.x+=stossWeite;}
        if (richtung==EProjektile.SUED){
            newPosition.y-=stossWeite;}
        if (richtung==EProjektile.WEST){
            newPosition.x-=stossWeite;}
        if (this.getLevel().getTileAt(newPosition.toCoordinate()).isAccessible()) {
            setPosition(newPosition);
        }
    }
}
