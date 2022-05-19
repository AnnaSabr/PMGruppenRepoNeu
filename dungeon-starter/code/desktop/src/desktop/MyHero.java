package desktop;

import basiselements.Animatable;
import basiselements.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;
import tools.Point;
import level.elements.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * Steuert die Animation von unserem wunderschoenen Helden
 */

public class MyHero extends Figuren {
    private Animation idleAnimation;


    private List<String> animation;
    private List<String> rechts;
    private List<String> links;
    String key="x";
    static Inventar itemInventar = new Inventar();
    static Items hand;
    private int lebenspunkte;

    /**
     * Erstellt die einzelnen Animationslisten und added die entsprechenden Animationen
     * startet Idle Animation
     * @param painter irgendwas mit Texturen
     * @param batch auch irgendwas mit Texturen
     */
    public MyHero(int lebenspunkte, int staerke, float geschwindigkeit, Painter painter, SpriteBatch batch) {
        super(lebenspunkte,staerke, geschwindigkeit,painter, batch);
        this.lebenspunkte=lebenspunkte;
        animation = new ArrayList<>();
        rechts= new ArrayList<>();
        links = new ArrayList<>();
        animation.add("character/held/wizzard/wizzard_m_idle_anim_f0.png");
        animation.add("character/held/wizzard/r/wizzard_m_idle_anim_f0.png");
        animation.add("character/held/wizzard/wizzard_m_idle_anim_f1.png");
        animation.add("character/held/wizzard/r/wizzard_m_idle_anim_f1.png");
        animation.add("character/held/wizzard/wizzard_m_idle_anim_f2.png");
        animation.add("character/held/wizzard/r/wizzard_m_idle_anim_f2.png");
        animation.add("character/held/wizzard/wizzard_m_idle_anim_f3.png");
        animation.add("character/held/wizzard/r/wizzard_m_idle_anim_f3.png");
        idleAnimation = new Animation(animation, 10); //der tanzt oder hat ne Ueberdosis

        rechts.add("character/held/wizzard/r/wizzard_m_run_anim_f0.png");
        rechts.add("character/held/wizzard/r/wizzard_m_run_anim_f1.png");
        rechts.add("character/held/wizzard/r/wizzard_m_run_anim_f2.png");
        rechts.add("character/held/wizzard/r/wizzard_m_run_anim_f3.png");

        links.add("character/held/wizzard/wizzard_m_run_anim_f0.png");
        links.add("character/held/wizzard/wizzard_m_run_anim_f1.png");
        links.add("character/held/wizzard/wizzard_m_run_anim_f2.png");
        links.add("character/held/wizzard/wizzard_m_run_anim_f3.png");
    }



    @Override
    public Animation getActiveAnimation() {
        return idleAnimation;
    }

    @Override
    public void update() {
        Point newPosition = new Point(getPosition());
        float movementSpeed = 0.1f+ SpeedPotion.SpeedIncrease;


        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            newPosition.y += movementSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            newPosition.x -= movementSpeed;
            if(key!="a") {
                idleAnimation = new Animation(links, 5);
                key="a";
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            newPosition.y -= movementSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            newPosition.x += movementSpeed;
            if(key!="d") {
                idleAnimation = new Animation(rechts, 5);
                key="d";
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.I)){
            itemInventar.anzeigen();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.L)){
            if(hand instanceof Potion){
                ((Potion) hand).usePotion();
            }
            else if(MyHero.hand instanceof Recipe){
                ((Recipe) MyHero.hand).lesen();
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.T)){
            if(hand!=null){
                hand=null;
            }
        }
        if (getLevel().getTileAt(newPosition.toCoordinate()).isAccessible()) {
            setPosition(newPosition);
        }
    }
}
