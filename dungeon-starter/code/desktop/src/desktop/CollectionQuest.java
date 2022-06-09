package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

public class CollectionQuest extends Quest{

    String texturePath;

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
    }

    int anzahl;

    public void chooseReward(Items items){
        String reward="Dafür erhältst du ";
        int zufall = (int) (Math.random()*12);
        Items item;
        if(zufall==0){
            item =new SpeedPotion(painter, batch);
            reward=reward+"einen Geschwindigkeitstrank";
        } else if (zufall==1) {
            item = new SpeedDecreasePotion(painter, batch);
            reward=reward+"einen Langsamkeitstrank";
        } else if (zufall==2) {
            item= new Sword(painter, batch);
            reward=reward+"ein Schwert";
        } else if (zufall==3) {
            item=new Axe(painter, batch);
            reward=reward+"eine Axt";
        } else if(zufall==4){
            item=new Kraut(painter, batch);
            reward=reward+"ein Kraut";
        } else if(zufall==5){
            item=new Wein(painter, batch);
            reward=reward+"einen Wein";
        } else if(zufall==6){
            item=new Kochtopf(painter, batch);
            reward=reward+"einen Kochtopf";
        } else if(zufall==7){
            item=new SpeedPotionRecipe(painter, batch);
            reward=reward+"ein Rezept für Geschwindigkeitstränke";
        }else if(zufall==8){
            item=new Hammer(painter,batch);
            reward=reward+"einen Hammer";
        }else if(zufall==9){
            item=new SwordRecipe(painter,batch);
            reward=reward+"ein Rezept für Schwerter";
        }else {
            item=new Iron(painter,batch);
            reward=reward+"ein Eisen";
        }
        if(items.getClass()==item.getClass()){
            this.chooseReward(items);
        }else{
            this.questReward=reward;
        }
    }

    public String chooseCollection(){
        this.anzahl = (int) (Math.random()*2) +2;
        String aufgabe = "Sammel " + this.anzahl + " ";
        int zufall = (int) (Math.random()*9);
        Items item;
        if(zufall==0){
            item =new SpeedPotion(painter, batch);
            aufgabe=aufgabe+"Geschwindigkeitstränke.";
        } else if (zufall==1) {
            item = new SpeedDecreasePotion(painter, batch);
            aufgabe=aufgabe+"Langsamkeitstränke";
        } else if (zufall==2) {
            item= new Sword(painter, batch);
            aufgabe=aufgabe+"Schwerter";
        } else if (zufall==3) {
            item=new Axe(painter, batch);
            aufgabe=aufgabe+"Äxte";
        } else if(zufall==4){
            item=new Kraut(painter, batch);
            aufgabe=aufgabe+"Kräuter";
        } else if(zufall==5){
            item=new Wein(painter, batch);
            aufgabe=aufgabe+"Weine";
        } else if(zufall==6){
            aufgabe=aufgabe+"Kochtöpfe";
            item=new Kochtopf(painter, batch);
        } else if(zufall==7){
            aufgabe=aufgabe+"Hämmer";
            item=new Hammer(painter,batch);
        }else{
            aufgabe=aufgabe+"Eisen";
            item=new Iron(painter,batch);
        }
        this.chooseReward(item);
        return aufgabe;
    }

    Point position;

    @Override
    public Point getPosition() {
        return position;
    }

    public void setLevel(Level currentLevel) {
    }

    public String getTexturePath() {
        return texturePath;
    }
}


