package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

public class Shop extends Entity {
    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Shop(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath="character/umgebung/gebaeude.png";
        int anzahl = (int) (Math.random()*5)+5;
        for(int a = 0; a<anzahl; a++){
            Items item;
            int zufall = (int) (Math.random()*13);
            if(zufall==0){
                item =new SpeedPotion(painter, batch);
            } else if (zufall==1) {
                item = new SpeedDecreasePotion(painter, batch);
            } else if (zufall==2) {
                item= new Sword(painter, batch);
            } else if (zufall==3) {
                item=new Axe(painter, batch);
            } else if (zufall==4) {
                zufall = (int) (Math.random()*2);
                if(zufall==0){
                    item = new Tasche<Weapon>(painter, batch);
                    item.nameTyp ="Waffen";
                }else {
                    item = new Tasche<Potion>(painter, batch);
                    item.nameTyp ="Tränke";
                }
            }else if(zufall==5){
                item=new Key(painter, batch);
            }else if(zufall==6){
                item=new Kraut(painter, batch);
            }else if(zufall==7){
                item=new Wein(painter, batch);
            }else if(zufall==8){
                item=new Kochtopf(painter, batch);
            }else if(zufall==9){
                item=new SpeedPotionRecipe(painter, batch);
            }else if(zufall==10){
                item=new Iron(painter, batch);
            }else if(zufall==11){
                item=new Hammer(painter,batch);
            }else{
                item=new SwordRecipe(painter,batch);
            }
            this.ware[a]=item;
        }

    }

    Items[] ware=new Items[9];
    String texturePath;

    public void setLevel(Level level) {
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

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
