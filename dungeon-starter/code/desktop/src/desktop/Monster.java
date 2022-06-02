package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;

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
}
