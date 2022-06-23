package desktop;

import basiselements.HUDElement;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.HUDPainter;
import tools.Point;

public class Kontostand extends HUDElement {

    /**
     * A object that can be controlled by the <code>HUDController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Kontostand(HUDPainter painter, SpriteBatch batch) {
        super(painter, batch);
        String a = String.valueOf(MyGame.geld);
        for(int b = 0; b<a.length(); b++){
            Character c=a.charAt(b);
            int d = Integer.getInteger(String.valueOf(c));
            new Ziffern(getPainter(),getBatch(),d,b);
        }
        position=new Point(700,0);
    }

    Point position;

    @Override
    public Point getPosition() {
        return position;
    }

    String texturePath;

    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
