package desktop;

import basiselements.HUDElement;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.HUDPainter;
import tools.Point;

public class Slot extends HUDElement {

    String texturePath;
    String[] texturen = {"character/items/barrelgrey_side_inv.png","character/items/book_inv.png","character/items/flask_blue_inv.png","character/items/bag_inv.png","character/items/key_inv.png","character/items/Hammer_inv.png","character/items/Nord_inv.png","character/items/Plant_inv.png","character/items/Topf_inv.png","character/items/weapon_axe_inv.png","character/items/weapon_katana_inv.png","character/items/wine_inv.png","character/items/yellow_book_inv.png","character/items/Leer_inv.png"};

    String[] handTexturen={"character/items/barrelgrey_side_hand.png","character/items/Book_Hand.png","character/items/flask_blue_Hand.png","character/items/bag_Hand.png","character/items/key_Hand.png","character/items/Hammer_Hand.png","character/items/Nord_Hand.png","character/items/Plant_Hand.png","character/items/Topf_Hand.png","character/items/weapon_axe_Hand.png","character/items/weapon_katana_Hand.png","character/items/Wine_Hand.png","character/items/yellow_book_Hand.png","character/items/Leer_Hand.png"};

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
            texturePath=handTexturen[objekt];
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
