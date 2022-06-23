package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;

import java.util.List;

/**
 * Individuelle Klasse zum Anpassen der Falle als Hole
 */
public class Holes extends Fallen{
    private List<String> animation;
    private List<String> action;

    public Holes(Painter painter, SpriteBatch batch){
        super(painter,batch);
        animation=getAnimation();
        action=getAction();

        animation.add("character/umgebung/hole.png");
        setIdleAnimation(new Animation(animation, 6));

        action.add("character/umgebung/floor_4.png");
    }

    @Override
    public void effekte(Figuren f){
        f.setPosition(f.getLevel().getRandomRoom().getRandomFloorTile().getCoordinate().toPoint());
    }
}
