package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;

import java.util.Scanner;

public class SwordRecipe extends Recipe{

    String texturePath;

    String inhalt;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public SwordRecipe(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        this.texturePath="character/items/yellow_book.png";
        this.inhalt="Eisen und Hammer";
    }

    /**prüft, ob alle benötigten Items im Inventar sind und setzt das Rezept um
     *
     * @return wurde das item entfernt
     */
    public boolean useRecipe(){
        boolean usable=false;
        System.out.println("Eisen");
        Scanner scanner= new Scanner(System.in);
        String eingabe=scanner.nextLine();
        int[] positionen=new int[2];
        try {
            int zahl = Integer.parseInt(eingabe);
            zahl--;
            positionen[0]=zahl;
            if(MyHero.itemInventar.holen(zahl) instanceof Iron){
                System.out.println("Hammer");
                eingabe=scanner.nextLine();
                try {
                    zahl = Integer.parseInt(eingabe);
                    zahl--;
                    positionen[1]=zahl;
                    if (MyHero.itemInventar.holen(zahl) instanceof Hammer) {
                        usable=true;
                    }
                }catch (Exception e){
                    System.out.println("nicht gefunden");
                }
            }
        }catch (Exception e){
            System.out.println("nicht gefunden");
        }
        if(usable){
            for(int a=0; a<MyHero.itemInventar.getSize(); a++){
                if(MyHero.itemInventar.holen(a) instanceof Iron){
                    MyHero.itemInventar.itemEntfernen(a);
                    break;
                }
            }
            for(int a=0; a<MyHero.itemInventar.getSize(); a++){
                if(MyHero.itemInventar.holen(a) instanceof Hammer){
                    MyHero.itemInventar.itemEntfernen(a);
                    break;
                }
            }
            MyHero.itemInventar.hinzufuegen(new Sword(getPainter(),getBatch()));
        }
        return usable;
    }


    @Override
    public String getTexturePath() {
        return texturePath;
    }

    public void setLevel(Level level) {
        Level currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    public boolean removable() {
        return taken;
    }

    /**
     * Inhalt des Rezepts ausgeben
     */
    public void lesen(){
        System.out.println(inhalt);
    }
}
