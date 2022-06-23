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
        texturePath="hud/Ziffer0.png";
        position=new Point(500,0);
        String a = String.valueOf(MyGame.geld);
        Character c=a.charAt(0);
        int d=Integer.parseInt(String.valueOf(c));
        z1=new Ziffern(painter,batch,d,0);
        if(MyGame.geld>9){
            c=a.charAt(1);
            d=Integer.parseInt(String.valueOf(c));
            z2=new Ziffern(painter,batch,d,1);
        }if(MyGame.geld>99){
            c=a.charAt(2);
            d=Integer.parseInt(String.valueOf(c));
            z3=new Ziffern(painter,batch,d,2);
        }
    }

    Ziffern z1;
    Ziffern z2;
    Ziffern z3;

    String[] texturen = {"hud/Ziffer0.png","hud/Ziffer1.png","hud/Ziffer2.png","hud/Ziffer3.png","hud/Ziffer4.png","hud/Ziffer5.png","hud/Ziffer6.png","hud/Ziffer7.png","hud/Ziffer8.png","hud/Ziffer9.png"};
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
