package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import graphic.Painter;

/**
 * Oberklasse der Npc
 *
 * enthaelt alle allgemein gueltigen Funktionen
 */
public abstract class  Npc extends Figuren{

    private FigurenBewegung bewegung;

    public Npc(FigurenBewegung bewegung,int lebenspunkte, int staerke, float geschwindigkeit, Painter painter, SpriteBatch batch){
        super(lebenspunkte,staerke,geschwindigkeit,painter,batch);
        this.bewegung=bewegung;
    }

    /**
     * ruft die individuelle Bewegung des Npcs auf
     */
    public void bewegen(){
        bewegung.bewegen(this);
    }


}
