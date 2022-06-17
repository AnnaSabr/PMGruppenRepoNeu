package desktop;

import basiselements.HUDElement;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.HUDPainter;
import tools.Point;

public class Slot extends HUDElement {

    String texturePath;
    String[] texturen = {"character/items/barrelgrey_side_inv.png","character/items/book_inv.png","character/items/flask_blue_inv.png","character/items/bag_inv.png","character/items/key_inv.png","character/items/Hammer_inv.png","character/items/Nord_inv.png","character/items/Plant_inv.png","character/items/Topf_inv.png","character/items/weapon_axe_inv.png","character/items/weapon katana_inv.png","character/items/wine_inv.png","character/items/yellow book_inv.png","character/items/key_Hand.png"};

    String[] handTexturen={};

    boolean hand;

    /**
     * A object that can be controlled by the <code>HUDController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Slot(HUDPainter painter, SpriteBatch batch, int objekt, boolean hand, Items i) {
        super(painter, batch);
        this.hand = hand;
        if(hand){
            texturePath=texturen[objekt];
        }else {
            texturePath=texturen[objekt];
        }
        this.items=i;
    }

    Items items;
    Point position;

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
