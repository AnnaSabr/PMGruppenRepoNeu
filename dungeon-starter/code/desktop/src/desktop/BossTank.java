package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;

import java.util.List;

/**
 * ein MonsterBoss der viel Leben hat und wunderschoen pink ist
 */
public class BossTank extends Monster{

    private Animation idleAnimation;
    private List<String> animation;

    public BossTank(FigurenBewegung bewegung,int lebenspunkte, int staerke, float geschwindigkeit, Painter painter, SpriteBatch batch){
        super(bewegung,lebenspunkte,staerke, geschwindigkeit, painter,batch);
        this.setLebenspunkteStart(lebenspunkte);
        this.setStaerke(staerke);
        this.setGeschwindigkeit(geschwindigkeit);
        this.animation=getAnimation();

        animation.add("character/Bosse/Tank/rechts.png");
        animation.add("character/Bosse/Tank/links.png");
        animation.add("character/Bosse/Tank/mitte.png");
        idleAnimation= new Animation(animation, 6);
    }

    @Override
    public Animation getActiveAnimation(){
        return idleAnimation;
    }

    @Override
    public int angriff(double distanz){
        if (this.getLebenspunkte()<this.getGesamtesLeben()/2){
            if (distanz<1){
                return getStaerke()+4;
            }
            else{
                return getStaerke()+2;
            }
        }
        else{
            if (distanz<1){
                return getStaerke()+1;
            }
            else{
                return getStaerke();
            }
        }
    }
}
