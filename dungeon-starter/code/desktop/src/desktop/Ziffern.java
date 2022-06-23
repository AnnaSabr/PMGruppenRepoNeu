package desktop;

import basiselements.HUDElement;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.HUDPainter;
import tools.Point;

public class Ziffern extends HUDElement {
    /**
     * A object that can be controlled by the <code>HUDController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Ziffern(HUDPainter painter, SpriteBatch batch, int wert, int stelle) {
        super(painter, batch);
        texturePath=texturen[wert];
        position=new Point(500+20*stelle,0);
    }

    @Override
    public Point getPosition() {
        return position;
    }

    Point position;

    String[] texturen = {"hud/Ziffer0.png","hud/Ziffer1.png","hud/Ziffer2.png","hud/Ziffer3.png","hud/Ziffer4.png","hud/Ziffer5.png","hud/Ziffer6.png","hud/Ziffer7.png","hud/Ziffer8.png","hud/Ziffer9.png"};
    String texturePath;
    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
