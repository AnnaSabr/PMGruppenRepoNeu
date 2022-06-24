package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;
import tools.Point;


import java.util.List;

/**
 * Individuelle Klasse zum Anpassen der Falle als Spike
 */
public class Spikes extends Fallen {

    private List<String> animation;
    private List<String> action;

    public Spikes (Painter painter, SpriteBatch batch){
        super(painter, batch);
        animation=getAnimation();
        action=getAction();

        animation.add("character/umgebung/floor_spikes/floor_spikes_anim_f0.png");
        animation.add("character/umgebung/floor_spikes/floor_spikes_anim_f1.png");
        animation.add("character/umgebung/floor_spikes/floor_spikes_anim_f2.png");
        animation.add("character/umgebung/floor_spikes/floor_spikes_anim_f3.png");
        setIdleAnimation(new Animation(animation, 6));

        action.add("character/umgebung/floor_spikes/floor_spikes_anim_f3.png");
    }

    @Override
    public void effekte(Figuren f){
        f.setLebenspunkte(1);
    }
}
