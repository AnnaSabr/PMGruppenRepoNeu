package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

import java.util.Scanner;

public class CollectionQuest extends Quest implements QuestObserver{

    String texturePath;

    Items taskItem;
    Items rewardItem;

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
                }else{
                    System.out.println("Auftrag abgelehnt");
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
     */
    public void chooseReward(){
        String reward="Dafür erhältst du ";
        int zufall = (int) (Math.random()*12);
        if(zufall==0){
            rewardItem=new SpeedPotion(getPainter(),getBatch());
            reward=reward+"einen Geschwindigkeitstrank";
        } else if (zufall==1) {
            rewardItem=new SpeedDecreasePotion(getPainter(),getBatch());
            reward=reward+"einen Langsamkeitstrank";
        } else if (zufall==2) {
            rewardItem=new Sword(getPainter(),getBatch());
            reward=reward+"ein Schwert";
        } else if (zufall==3) {
            rewardItem=new Axe(getPainter(),getBatch());
            reward=reward+"eine Axt";
        } else if(zufall==4){
            rewardItem= new Kraut(getPainter(),getBatch());
            reward=reward+"ein Kraut";
        } else if(zufall==5){
            rewardItem=new Wein(getPainter(),getBatch());
            reward=reward+"einen Wein";
        } else if(zufall==6){
            rewardItem=new Kochtopf(getPainter(),getBatch());
            reward=reward+"einen Kochtopf";
        } else if(zufall==7){
            rewardItem=new Hammer(getPainter(),getBatch());
            reward=reward+"einen Hammer";
        }else if(zufall==8){
            rewardItem=new Iron(getPainter(),getBatch());
            reward=reward+"ein Eisen";
        }else if(zufall==9){
            rewardItem=new SwordRecipe(getPainter(),getBatch());
            reward=reward+"ein Rezept für Schwerter";
        }else {
            rewardItem=new SpeedPotionRecipe(getPainter(),getBatch());
            reward=reward+"ein Rezept für Geschwindigkeitstränke";
        }
        if(taskItem==rewardItem){
            this.chooseReward();
        }
        else {
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
            taskItem=new SpeedPotion(getPainter(),getBatch());
            aufgabe=aufgabe+"Geschwindigkeitstränke.";
        } else if (zufall==1) {
            taskItem=new SpeedDecreasePotion(getPainter(),getBatch());
            aufgabe=aufgabe+"Langsamkeitstränke";
        } else if (zufall==2) {
            taskItem=new Sword(getPainter(),getBatch());
            aufgabe=aufgabe+"Schwerter";
        } else if (zufall==3) {
            taskItem=new Axe(getPainter(),getBatch());
            aufgabe=aufgabe+"Äxte";
        } else if(zufall==4){
            taskItem=new Kraut(getPainter(),getBatch());
            aufgabe=aufgabe+"Kräuter";
        } else if(zufall==5){
            taskItem=new Wein(getPainter(),getBatch());
            aufgabe=aufgabe+"Weine";
        } else if(zufall==6){
            taskItem=new Kochtopf(getPainter(),getBatch());
            aufgabe=aufgabe+"Kochtöpfe";
        } else if(zufall==7){
            taskItem=new Hammer(getPainter(),getBatch());
            aufgabe=aufgabe+"Hämmer";
        }else{
            taskItem=new Iron(getPainter(),getBatch());
            aufgabe=aufgabe+"Eisen";
        }
        this.chooseReward();
        return aufgabe;
    }


    public void setLevel(Level level) {
        Level currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }


    public String getTexturePath() {
        return texturePath;
    }

    @Override
    public void questUpdate() {

    }
}


