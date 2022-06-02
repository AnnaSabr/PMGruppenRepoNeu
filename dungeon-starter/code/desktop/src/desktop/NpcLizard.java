package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;

/**
 * spezieller Npc der zur Motivation da ist
 */
public class NpcLizard extends Npc {

    public NpcLizard(FigurenBewegung bewegung, int lebenspunkte, int staerke, float geschwindigkeit, Painter painter, SpriteBatch batch){
        super(bewegung,lebenspunkte,staerke,geschwindigkeit,painter,batch);

        getAnimation().add("npcs/lizard/idle/lizard_m_idle_anim_f0.png");
        getAnimation().add("npcs/lizard/idle/lizard_m_idle_anim_f1.png");
        getAnimation().add("npcs/lizard/idle/lizard_m_idle_anim_f2.png");
        getAnimation().add("npcs/lizard/idle/lizard_m_idle_anim_f3.png");
        getAnimation().add("npcs/lizard/idle/lizard_m_idle_anim_f0l.png");
        getAnimation().add("npcs/lizard/idle/lizard_m_idle_anim_f1l.png");
        getAnimation().add("npcs/lizard/idle/lizard_m_idle_anim_f2l.png");
        getAnimation().add("npcs/lizard/idle/lizard_m_idle_anim_f3l.png");
        setIdleAnimation(new Animation(getAnimation(),6));

        getRechts().add("npcs/lizard/r/lizard_m_run_anim_f0.png");
        getRechts().add("npcs/lizard/r/lizard_m_run_anim_f1.png");
        getRechts().add("npcs/lizard/r/lizard_m_run_anim_f2.png");
        getRechts().add("npcs/lizard/r/lizard_m_run_anim_f3.png");

        getLinks().add("npcs/lizard/l/lizard_m_run_anim_f0.png");
        getLinks().add("npcs/lizard/l/lizard_m_run_anim_f1.png");
        getLinks().add("npcs/lizard/l/lizard_m_run_anim_f2.png");
        getLinks().add("npcs/lizard/l/lizard_m_run_anim_f3.png");
    }

    @Override
    public void update(){
        if (getTime() % 50 == 0) {
            bewegen();
        }
        setTime(getTime()+1);
    }

}
