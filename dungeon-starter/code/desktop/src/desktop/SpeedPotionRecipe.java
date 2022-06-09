package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

import java.util.Scanner;

public class SpeedPotionRecipe extends Recipe{

    String texturePath;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public SpeedPotionRecipe(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        this.inhalt="Kraut, Wein und Kochtopf";
        this.texturePath="character/items/book.png";
    }

    /**
     * Prüft, ob das Item nach dem Rezept erzeugt werden kann
     *
     * @return wurde das Rezept verwendet
     */
    public boolean useRecipe(){
        boolean usable=false;
        System.out.println("Kraut");
        Scanner scanner= new Scanner(System.in);
        String eingabe=scanner.nextLine();
        int[] positionen=new int[3];
        try {
            int zahl = Integer.parseInt(eingabe);
            zahl--;
            positionen[0]=zahl;
            if(MyHero.itemInventar.holen(zahl) instanceof Kraut){
                System.out.println("Wein");
                eingabe=scanner.nextLine();
                try {
                    zahl = Integer.parseInt(eingabe);
                    zahl--;
                    positionen[1]=zahl;
                    if (MyHero.itemInventar.holen(zahl) instanceof Wein) {
                        System.out.println("Kochtopf");
                        eingabe=scanner.nextLine();
                        try {
                            zahl = Integer.parseInt(eingabe);
                            zahl--;
                            positionen[2]=zahl;
                            if(MyHero.itemInventar.holen(zahl) instanceof Kochtopf){
                                usable=true;
                            }
                        }catch (Exception e){
                            System.out.println("nicht gefunden");
                        }
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
                if(MyHero.itemInventar.holen(a) instanceof Wein){
                    MyHero.itemInventar.itemEntfernen(a);
                    break;
                }
            }
            for(int a=0; a<MyHero.itemInventar.getSize(); a++){
                if(MyHero.itemInventar.holen(a) instanceof Kochtopf){
                    MyHero.itemInventar.itemEntfernen(a);
                    break;
                }
            }
            for(int a=0; a<MyHero.itemInventar.getSize(); a++){
                if(MyHero.itemInventar.holen(a) instanceof Kraut){
                    MyHero.itemInventar.itemEntfernen(a);
                    break;
                }
            }
            SpeedPotion speedPotion = new SpeedPotion(getPainter(),getBatch());
            speedPotion.crafted=true;
            MyHero.itemInventar.hinzufuegen(speedPotion);
        }
        return usable;
    }

    public void setLevel(Level level) {
        Level currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    public boolean removable() {
        return taken;
    }

    /**
     * gibt den Inhalt des Rezepts aus
     */
    public void lesen(){
        System.out.println(inhalt);
    }

    public String getTexturePath() {
        return texturePath;
    }
}
