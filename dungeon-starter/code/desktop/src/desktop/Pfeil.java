package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.room.Tile;
import tools.Point;

/**
 * bestimmtes Projektil
 */
public class Pfeil extends Projektil {


    private EProjektile richtung;
    private MyHero hero;
    private boolean geschossen;
    private boolean kaputt;


    public Pfeil(MyHero hero, EProjektile richtung, Painter painter, SpriteBatch batch) {
        super(painter, batch);
        this.richtung = richtung;
        this.hero = hero;
        setNord("character/kampf/pfeil/nord.png");
        setOst("character/kampf/pfeil/ost.png");
        setSued("character/kampf/pfeil/sued.png");
        setWest("character/kampf/pfeil/west.png");
        setLeer("character/kampf/pfeil/leer.png");
        this.setPosition(hero.getPosition());
        geschossen = false;
        kaputt = false;


    }

    @Override
    public String getTexturePath() {
        if (richtung == EProjektile.NORD) {
            return getNord();
        } else if (richtung == EProjektile.OST) {
            return getOst();
        } else if (richtung == EProjektile.SUED) {
            return getSued();
        } else if (richtung == EProjektile.WEST) {
            return getWest();
        }
        else if (richtung==EProjektile.LEER){
            return getLeer();
        }
        return null;
    }

    /**
     *
     * @return ob der Pfeil an einer Wand oder ein Monster gekommen ist
     */
    public boolean isKaputt() {
        return kaputt;
    }

    @Override
    public void schiessen(EProjektile eP) {
        geschossen = true;
        richtung = eP;
        Point newPosition = new Point(getPosition());
        float flugWeite = 0.1f;

        if (eP == EProjektile.NORD) {
            newPosition.y += flugWeite;
        } else if (eP == EProjektile.OST) {
            newPosition.x += flugWeite;
        } else if (eP == EProjektile.SUED) {
            newPosition.y -= flugWeite;
        } else if (eP == EProjektile.WEST) {
            newPosition.x -= flugWeite;
        }
        try{
            Tile tile =this.getLevel().getTileAt(newPosition.toCoordinate());
            if (tile!=null&&tile.isAccessible()) {
                setPosition(newPosition);
            } else {
                kaputt = true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            kaputt=true;
        }
    }

    @Override
    public boolean removable() {
        return kaputt;
    }

    @Override
    public void update() {
        if (geschossen) {
            schiessen(richtung);
        }
        else{
            richtung=EProjektile.LEER;
            this.setPosition(hero.getPosition());
        }
    }

    /**
     *
     * @return die Richtung in die der Pfeil geht
     */
    public EProjektile getRichtung() {
        return richtung;
    }

    /**
     * setzt den Zustand des Pfeils auf kaputt
     */
    public void schrott(){
        this.kaputt=true;
    }

}
