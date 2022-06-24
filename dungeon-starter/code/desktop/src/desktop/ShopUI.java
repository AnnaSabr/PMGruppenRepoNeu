package desktop;

import basiselements.HUDElement;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.HUDPainter;
import tools.Point;

public class ShopUI extends HUDElement {
    /**
     * A object that can be controlled by the <code>HUDController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public ShopUI(HUDPainter painter, SpriteBatch batch, Shop shop) {
        super(painter, batch);
        position=new Point(150,50);
        texturePath="character/items/Leer_inv.png";
        slot1 = new Slot(painter,batch,this.slotNumber(shop.ware[0]),false,shop.ware[0]);
        slot1.position=new Point(150,50);
        slot2 = new Slot(painter,batch,this.slotNumber(shop.ware[1]),false,shop.ware[1]);
        slot2.position=new Point(202,50);
        slot3 = new Slot(painter,batch,this.slotNumber(shop.ware[2]),false,shop.ware[2]);
        slot3.position=new Point(254,50);
        slot4 = new Slot(painter,batch,this.slotNumber(shop.ware[3]),false,shop.ware[3]);
        slot4.position=new Point(150,102);
        slot5 = new Slot(painter,batch,this.slotNumber(shop.ware[4]),false,shop.ware[4]);
        slot5.position=new Point(202,102);
        slot6 = new Slot(painter,batch,this.slotNumber(shop.ware[5]),false,shop.ware[5]);
        slot6.position=new Point(254,102);
        slot7 = new Slot(painter,batch,this.slotNumber(shop.ware[6]),false,shop.ware[6]);
        slot7.position=new Point(150,154);
        slot8 = new Slot(painter,batch,this.slotNumber(shop.ware[7]),false,shop.ware[7]);
        slot8.position=new Point(202,154);
        slot9 = new Slot(painter,batch,this.slotNumber(shop.ware[8]),false,shop.ware[8]);
        slot9.position=new Point(254,154);
    }

    Slot slot1;
    Slot slot2;
    Slot slot3;
    Slot slot4;
    Slot slot5;
    Slot slot6;
    Slot slot7;
    Slot slot8;
    Slot slot9;


    Point position;

    String texturePath;
    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }

    /**
     * berechnet, welche Zahl an den Konstruktor von Slot übergeben wird
     * @param items Item, das angezeigt werden soll
     * @return
     */
    public int slotNumber(Items items){
        if(items==null){
            return 14;
        }
        if(items instanceof Iron){
            return 0;
        }else if(items instanceof SpeedPotionRecipe){
            return 1;
        } else if (items instanceof SpeedPotion) {
            return 2;
        }else if(items instanceof Tasche<?>){
            return 3;
        }else if(items instanceof Key){
            return 4;
        }else if(items instanceof Hammer){
            return 5;
        } else if (items instanceof Pfeil) {
            return 6;
        }else if(items instanceof Kraut){
            return 7;
        }else if(items instanceof Kochtopf){
            return 8;
        }else if(items instanceof Axe){
            return 9;
        }else if (items instanceof Sword){
            return 10;
        } else if (items instanceof Wein) {
            return 11;
        }else if(items instanceof SwordRecipe){
            return 12;
        } else if (items instanceof SpeedDecreasePotion) {
            return 13;
        } else{
            return 14;
        }
    }

}
