package desktop;

import basiselements.HUDElement;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.HUDPainter;
import level.elements.Level;
import tools.Point;

public class InventarUI extends HUDElement {

    /**
     * A object that can be controlled by the <code>HUDController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public InventarUI(HUDPainter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath="character/items/Rucksack_mit_Hand.png";
        position = new Point(0,0);

        Items[] i = new Items[5];
        for(int a=0; a<MyHero.itemInventar.inventar.size(); a++){
            i[a] = MyHero.itemInventar.inventar.get(a);
        }
        slot1 = new Slot(painter,batch,this.slotNumber(i[0]),false,i[0]);
        slot1.position = new Point(0,0);
        slot2 = new Slot(painter,batch,this.slotNumber(i[1]),false,i[1]);
        slot2.position = new Point(52,0);
        slot3 = new Slot(painter,batch,this.slotNumber(i[2]),false,i[2]);
        slot3.position = new Point(104,0);
        slot4 = new Slot(painter,batch,this.slotNumber(i[3]),false,i[3]);
        slot4.position = new Point(156,0);
        slot5 = new Slot(painter,batch,this.slotNumber(i[4]),false,i[4]);
        slot5.position = new Point(208,0);
        slotHand = new Slot(painter,batch,this.slotNumber(MyHero.hand),true,MyHero.hand);
        slotHand.position = new Point(260,0);
    }

    Slot ausgewaehlt;
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

    Slot slot1;
    Slot slot2;
    Slot slot3;
    Slot slot4;
    Slot slot5;
    Slot slotHand;

    /**
     *  bestimmt die Position im aktuellen Level
     * @param level ist das aktuelle Level
     */
    public void setLevel(Level level) {
        currentLevel = level;
    }

    /**
     *
     * @return das aktuelle Level
     */
    public Level getLevel(){
        return this.currentLevel;
    }

    private Level currentLevel;
    String texturePath;
    Point position;
    boolean invisible = false;

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }

    @Override
    public boolean removable() {
        return this.invisible;
    }
}
