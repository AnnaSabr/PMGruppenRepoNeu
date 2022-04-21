package desktop;

import basiselements.HUDElement;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.HUDPainter;
import tools.Point;


/**
 * Bestimmt die position und die Texture des Lebens
 */
public class Icon extends HUDElement {
    private String texturePath;
    private Point position;


    /**
     *
     * @param painter irgendwas mit Texturen
     * @param batch auch irgendwas mit Texturen
     * @param position Uebergibt position des Lebens
     */
    public Icon(HUDPainter painter, SpriteBatch batch, Point position) {
        super(painter, batch);
        texturePath = "hud/ui_heart_full.png";
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
