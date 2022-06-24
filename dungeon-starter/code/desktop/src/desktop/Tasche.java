package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tasche<T extends Items> extends Items{

    List<T> tascheInventar= new ArrayList<>();
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

    /**
     * Item aus Tasche ausrüsten
     */
    public void ausruestenTasche(){
        System.out.println("Welches Item aus der Tasche soll ausgeruestet werden?");
        Scanner scanner= new Scanner(System.in);
        String eingabe=scanner.nextLine();
        try{
            int zahl = Integer.parseInt(eingabe);
            zahl--;
            Items x;
            if(MyHero.hand!=null){
                x = MyHero.hand;
                MyHero.hand = tascheInventar.get(zahl);
                try {
                    if (x instanceof Weapon && this.nameTyp == "Waffen") {
                        T weapon = (T) x;
                        tascheInventar.add(weapon);
                    } else if (x instanceof Potion && this.nameTyp == "Tränke") {
                        T potion = (T) x;
                        tascheInventar.add(potion);
                    }
                }catch (Exception e){
                    MyHero.itemInventar.hinzufuegen(x);
                }
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

    /**
     * Inhalt der Tasche ausgeben
     */
    public void inhaltAusgeben(){
        if(tascheInventar.isEmpty()){
            System.out.println("Die Tasche ist leer.");
        }else{
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
                } else if (tascheInventar.get(a) instanceof Key) {
                    name="Schluessel";
                }
                System.out.println((a+1)+": " + name);
            }
            ausruestenTasche();
            entfernenTasche();
        }
    }


    /**
     * Item aus Tasche entfernen
     */
    public void entfernenTasche(){
        System.out.println("Welches Item soll aus der Tasche entfernt werden?");
        Scanner scanner= new Scanner(System.in);
        String eingabe=scanner.nextLine();
        try{
            int zahl = Integer.parseInt(eingabe);
            zahl--;
            tascheInventar.remove(zahl);
            zahl=zahl+1;
            System.out.println("Item " + zahl +" wurde entfernt.");
        } catch (Exception e) {
            System.out.println("Kein Item wurde entfernt.");
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
