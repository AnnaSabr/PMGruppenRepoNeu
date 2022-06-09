package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

public class CraftingQuest extends Quest{

    String texturePath;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public CraftingQuest(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        this.questTask=this.chooseTask();
    }

    public String chooseTask(){
        String aufgabe="Erstelle mit Crafing ";
        int zufall=((int) Math.random()*2);
        if(zufall==0){
            aufgabe=aufgabe+"einen Trank";
        }else{
            aufgabe=aufgabe+"eine Waffe";
        }
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
