package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tasche<T extends Items> extends Items{

    List<T> tascheInventar;
    String texturePath;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Tasche(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath="character/items/genericItem_color_144.png";
    }

    public void ausruestenTasche(){
        System.out.println("Welches Item soll ausgeruestet werden?");
        Scanner scanner= new Scanner(System.in);
        String eingabe=scanner.nextLine();
        try{
            int zahl = Integer.parseInt(eingabe);
            zahl--;
            Items x;
            if(MyHero.hand!=null){
                x = MyHero.hand;
                MyHero.hand= tascheInventar.get(zahl);
                try{
                    if(tascheInventar.size()<3){
                        tascheInventar.add((T) x);
                        tascheInventar.remove(zahl);
                    }
                    else{
                        if(!MyHero.itemInventar.hinzufuegen(x)){
                            MyHero.hand=x;
                        }
                    }
                } catch (Exception e) {
                    if(!MyHero.itemInventar.hinzufuegen(x)){
                        MyHero.hand=x;
                    }
                }
                //tascheInventar.remove(zahl);
            }
            else{
                MyHero.hand= tascheInventar.get(zahl);
                tascheInventar.remove(zahl);
            }
            zahl=zahl+1;
            System.out.println("Item "+ zahl + " wurde ausgeruestet.");
        } catch (Exception e) {
            System.out.println("Kein Item wurde ausgeruestet.");
        }
    }

    public void inhaltAusgeben(){
        if(tascheInventar.isEmpty()){
            System.out.println("Die Tasche ist leer.");
        }
        for(int a=0; a<tascheInventar.size(); a++){
            String name="Item";
            if(tascheInventar.get(a) instanceof Axe){
                name="Axt";
            } else if (tascheInventar.get(a) instanceof Sword) {
                name="Schwert";
            } else if (tascheInventar.get(a) instanceof SpeedPotion) {
                name="Schnelligkeitstrank";
            } else if (tascheInventar.get(a) instanceof SpeedDecreasePotion) {
                name="Langsamkeitstrank";
            } else if (tascheInventar.get(a) instanceof Tasche<?>) {
                name="Tasche fuer "+ ((Tasche<?>) tascheInventar.get(a)).nameTyp;
            }
            System.out.println((a+1)+": " + name);
        }
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }

    public boolean removable(){
        return taken;
    }

    public void setLevel(Level level) {
        Level currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }
}
