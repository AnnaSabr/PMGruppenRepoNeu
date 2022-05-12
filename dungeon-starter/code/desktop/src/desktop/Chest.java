package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chest extends Entity {

    Inventar schatz=new Inventar();
    String texturePath;
    boolean offen = false;
    Point position;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Chest(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath="character/items/chest_closed.png";
    }

    /**
     * Truhe öffnen und Items einsammeln
     */
    public void oeffnen(){
        schatz.ausgeben();
        texturePath="character/items/chest_open.png";
        offen=true;
        if(!schatz.inventar.isEmpty()){
            System.out.println("Welches Item soll gesammelt werden?");
            Scanner scanner= new Scanner(System.in);
            String eingabe=scanner.nextLine();
            try{
                int zahl = Integer.parseInt(eingabe);
                zahl=zahl-1;
                MyHero.itemInventar.hinzufuegen(schatz.holen(zahl));
                this.schatz.itemEntfernen(zahl);
            } catch (Exception e) {
                System.out.println("Kein Item wurde gesammelt.");
            }
        }
    }

    public void setLevel(Level level) {
        Level currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    @Override
    public Point getPosition() {
        return position;
    }


    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
