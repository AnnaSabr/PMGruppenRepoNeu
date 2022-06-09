package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

import java.util.Scanner;

public class CollectionQuest extends Quest{

    String texturePath;


    @Override
    public void questVorschlagen() {
        if(!accepted){
            System.out.println(questTask);
            System.out.println(questReward);
            System.out.println("Drücke 1 um die Aufgabe anzunehmen");
            Scanner scanner = new Scanner(System.in);
            String eingabe = scanner.nextLine();
            try{
                int eingegeben = Integer.parseInt(eingabe);
                if(eingegeben==1){
                    System.out.println("Auftrag angenommen");
                    this.accepted=true;
                    MyHero.acceptedQuest.add(this);
                    texturePath="character/umgebung/Ausrufezeichen.png";
                }
            }catch (Exception exception){
                System.out.println("Auftrag abgelehnt");
            }
        }else{
            System.out.println("Der Auftrag wurde bereits angenommen.");
        }
    }

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public CollectionQuest(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        this.questTask =this.chooseCollection();
        this.texturePath="character/umgebung/Fragezeichen.png";
    }

    int anzahl;

    int collectZahl;

    int rewardZahl;

    /**
     * zufällige Belohnung wählen
     *
     * @param itemZahl Zahl des Items für die Aufgabe, damit Belohnung und Aufgabe nicht gleich sind
     */
    public void chooseReward(int itemZahl){
        String reward="Dafür erhältst du ";
        int zufall = (int) (Math.random()*12);
        Items item;
        if(zufall==0){
            reward=reward+"einen Geschwindigkeitstrank";
        } else if (zufall==1) {
            reward=reward+"einen Langsamkeitstrank";
        } else if (zufall==2) {
            reward=reward+"ein Schwert";
        } else if (zufall==3) {
            reward=reward+"eine Axt";
        } else if(zufall==4){
            reward=reward+"ein Kraut";
        } else if(zufall==5){
            reward=reward+"einen Wein";
        } else if(zufall==6){
            reward=reward+"einen Kochtopf";
        } else if(zufall==7){
            reward=reward+"einen Hammer";
        }else if(zufall==8){
            reward=reward+"ein Eisen";
        }else if(zufall==9){
            reward=reward+"ein Rezept für Schwerter";
        }else {
            reward=reward+"ein Rezept für Geschwindigkeitstränke";
        }
        if(itemZahl==zufall){
            this.chooseReward(itemZahl);
        }
        else {
            this.rewardZahl = zufall;
            this.questReward = reward;
        }
    }

    /**
     * wählt zufällig eine Aufgabe aus
     *
     * @return Text, in dem die Aufgabe erklärt wird
     */
    public String chooseCollection(){
        this.anzahl = (int) (Math.random()*2) +2;
        String aufgabe = "Sammel " + this.anzahl + " ";
        int zufall = (int) (Math.random()*9);
        if(zufall==0){
            aufgabe=aufgabe+"Geschwindigkeitstränke.";
        } else if (zufall==1) {
            aufgabe=aufgabe+"Langsamkeitstränke";
        } else if (zufall==2) {
            aufgabe=aufgabe+"Schwerter";
        } else if (zufall==3) {
            aufgabe=aufgabe+"Äxte";
        } else if(zufall==4){
            aufgabe=aufgabe+"Kräuter";
        } else if(zufall==5){
            aufgabe=aufgabe+"Weine";
        } else if(zufall==6){
            aufgabe=aufgabe+"Kochtöpfe";
        } else if(zufall==7){
            aufgabe=aufgabe+"Hämmer";
        }else{
            aufgabe=aufgabe+"Eisen";
        }
        this.chooseReward(zufall);
        this.collectZahl=zufall;
        return aufgabe;
    }


    public void setLevel(Level level) {
        Level currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }


    public String getTexturePath() {
        return texturePath;
    }
}


