package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;


import java.util.List;


public class Skelet extends Monster {

    private Animation idleAnimation;
    private List<String> animation;
    private List<String> links;
    private List<String> rechts;


    public Skelet(int staerke, float geschwindigkeit, int lebenspunkte,Painter painter, SpriteBatch batch) {
        super(staerke,geschwindigkeit,lebenspunkte,painter, batch);
        animation=getAnimation();
        links= getLinks();
        rechts= getRechts();

        animation.add("character/monster/skelet/skelet_idle_anim_f0.png");
        animation.add("character/monster/skelet/skelet_idle_anim_f1.png");
        animation.add("character/monster/skelet/skelet_idle_anim_f2.png");
        animation.add("character/monster/skelet/skelet_idle_anim_f3.png");
        idleAnimation = new Animation(animation, 6);

        rechts.add("character/monster/skelet/rechts/skelet_run_anim_f0.png");
        rechts.add("character/monster/skelet/rechts/skelet_run_anim_f1.png");
        rechts.add("character/monster/skelet/rechts/skelet_run_anim_f2.png");
        rechts.add("character/monster/skelet/rechts/skelet_run_anim_f3.png");

        links.add("character//monster/skelet/links/skelet_run_anim_f0.png");
        links.add("character//monster/skelet/links/skelet_run_anim_f1.png");
        links.add("character//monster/skelet/links/skelet_run_anim_f2.png");
        links.add("character//monster/skelet/links/skelet_run_anim_f3.png");
    }

    @Override
    public Animation getActiveAnimation() {
        return idleAnimation;
    }
}
