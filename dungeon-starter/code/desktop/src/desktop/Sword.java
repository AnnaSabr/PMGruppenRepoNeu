package desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

public class Sword extends Weapon{



    String texturePath;

    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Sword(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath="character/items/weapon_katana.png";
    }

    boolean crafted= false;
    public void setLevel(Level level) {
        Level currentLevel = level;
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    public boolean removable() {/*
        float x = MyHero.position.x;
        float y = MyHero.position.y;

        int coordx = (int) getPosition().x;
        int coordy = (int) getPosition().y;

        if(x>coordx-1&&x<coordx+1) {
            if (y > coordy - 1 && y < coordy + 1) {
                if(Gdx.input.isKeyPressed(Input.Keys.E)){
                   return Inventar.hinzufuegen(this);
                }
            }
        }*/
        return taken;
    }


    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
