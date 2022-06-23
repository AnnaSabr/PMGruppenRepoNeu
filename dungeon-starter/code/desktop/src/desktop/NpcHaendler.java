package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;

/**
 * Spezieller NPC der fuer die Haendler Funktion vorgesehen ist
 */
public class NpcHaendler extends Npc{
    private Key key;

    public NpcHaendler(FigurenBewegung bewegung, int lebenspunkte, int staerke, float geschwindigkeit, Painter painter, SpriteBatch batch){
        super(bewegung,lebenspunkte,staerke,geschwindigkeit,painter,batch);

        this.key=new Key(painter,batch);

        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f0.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f1.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f2.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f3.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f0l.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f1l.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f2l.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f3l.png");
        setIdleAnimation(new Animation(getAnimation(),6));


    }

    /**
     *
     * @return gibt das erstelle Item zurueck
     */
    public Key getKey(){
        return this.key;
    }

    @Override
    public void update(){
        if (getTime()%50==0){
            bewegen();
        }
        setTime(getTime()+1);

    }


}
