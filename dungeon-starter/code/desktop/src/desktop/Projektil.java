package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;

/**
 * Oberklasse duer die unterschiedlichen Projektil Arten
 */
public abstract class Projektil extends Items {

    private String nord;
    private String sued;
    private String ost;
    private String west;
    private String leer;


    public Projektil(Painter painter, SpriteBatch batch) {
        super(painter, batch);
    }

    /**
     *
     * @return die leere Textur, wenn das Projektil noch nicht verschossen ist
     */
    public String getLeer() {
        return leer;
    }

    /**
     *
     * @param leer um die entsprechende Textur zu uebergeben
     */
    public void setLeer(String leer) {
        this.leer = leer;
    }


    /**
     * Bestimmt den in Projektilen die FLugbahn
     * @param eP Richtung des Schusses
     */
    public abstract void schiessen(EProjektile eP);


    /**
     *
     * @return Textur fuer nach oben schiessen
     */
    public String getNord() {
        return nord;
    }


    /**
     *
     * @return Textur fuer nach unten schiessen
     */
    public String getSued() {
        return sued;
    }


    /**
     *
     * @return Textur fuer nach rechts schiessen
     */
    public String getOst() {
        return ost;
    }


    /**
     *
     * @return Textur fuer nach links schiessen
     */
    public String getWest() {
        return west;
    }


    /**
     *
     * @param nord setzt Textur um nach oben zu schiessen
     */
    public void setNord(String nord) {
        this.nord = nord;
    }

    /**
     *
     * @param sued setzt Textur um nach unten zu schiessen
     */
    public void setSued(String sued) {
        this.sued = sued;
    }

    /**
     *
     * @param ost setzt Textur um nach rechts zu schiessen
     */
    public void setOst(String ost) {
        this.ost = ost;
    }

    /**
     *
     * @param west setzt Textur um nach links zu schiessen
     */
    public void setWest(String west) {
        this.west = west;
    }
}
