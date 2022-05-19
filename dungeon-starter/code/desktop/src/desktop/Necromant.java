package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;

import java.util.List;

/**
 * Individuelle Klasse zur Anpassung des Necromanten an Monster
 */

public class Necromant extends Monster{
    private Animation idleAnimation;
    private List<String> animation;
    private List<String> links;
    private List<String> rechts;


    public Necromant(MonsterBewegung bewegung,int staerke, float geschwindigkeit, int lebenspunkte, Painter painter, SpriteBatch batch) {
        super(bewegung,lebenspunkte,staerke,geschwindigkeit,painter, batch);
        animation=getAnimation();
        links= getLinks();
        rechts= getRechts();

        animation.add("character/monster/necro/necromancer_idle_anim_f0.png");
        animation.add("character/monster/necro/necromancer_idle_anim_f1.png");
        animation.add("character/monster/necro/necromancer_idle_anim_f2.png");
        animation.add("character/monster/necro/necromancer_idle_anim_f3.png");
        idleAnimation = new Animation(animation, 6);

        rechts.add("character/monster/necro/rechts/necromancer_run_anim_f0.png");
        rechts.add("character/monster/necro/rechts/necromancer_run_anim_f1.png");
        rechts.add("character/monster/necro/rechts/necromancer_run_anim_f2.png");
        rechts.add("character/monster/necro/rechts/necromancer_run_anim_f3.png");

        links.add("character//monster/necro/links/necromancer_run_anim_f0.png");
        links.add("character//monster/necro/links/necromancer_run_anim_f1.png");
        links.add("character//monster/necro/links/necromancer_run_anim_f2.png");
        links.add("character//monster/necro/links/necromancer_run_anim_f3.png");
    }

    @Override
    public Animation getActiveAnimation() {
        return idleAnimation;
    }
}
