package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import graphic.Painter;
import tools.Point;

public class FallenCreator {

    private FallenCreator(){}

    /**
     *
     * @param fallenArt Art der Falle
     * @param painter irgendwas mit Texturen
     * @param batch irgendwas mit Texturen
     * @return gibt die erzeugte Falle zurueck
     */
    public static Fallen getFallen(EFallen fallenArt,  Painter painter, SpriteBatch batch) {
        if (fallenArt == EFallen.SPIKES) {
            Spikes spike = new Spikes(painter, batch);
            return spike;
        }
        if (fallenArt == EFallen.HOLE) {
            Holes h = new Holes(painter, batch);
            return h;
        }
        return null;
    }

}
