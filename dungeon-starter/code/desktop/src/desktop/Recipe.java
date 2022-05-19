package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import tools.Point;

public abstract class Recipe extends Items{

    String inhalt="";

    String texturePath;
    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Recipe(Painter painter, SpriteBatch batch) {
        super(painter, batch);
    }

    /**
     * gibt den Inhalt des Rezepts aus
     */
    public void lesen(){
        System.out.println(inhalt);
    }

    /**
     * verwendet das Rezept
     * @return konnte das Rezept verwendet werden
     */
    public boolean useRecipe(){
        return false;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
