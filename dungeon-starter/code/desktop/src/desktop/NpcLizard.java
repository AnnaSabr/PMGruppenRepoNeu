package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;

import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * spezieller Npc der zur Motivation da ist
 */
public class NpcLizard extends Npc {

    Logger logger = Logger.getLogger(this.getClass().getName());

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

    @Override
    public void dialog() {
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new DialogFormatter());
        logger.addHandler(handler);
        boolean imGespreach = true;
        while (imGespreach) {
            logger.info("Sag was:\n");
            DialogAntwortArt ausgewaehlt = auswertungEingabe(sprachEingabe());

            if (ausgewaehlt.equals(DialogAntwortArt.BEGRUESSUNG)) {
                logger.info("Was willst du?\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.BELEIDIGUNG)) {
                logger.info("DU wagst es mich zu beleidigen??\n" +
                    "Meine Vorfahren haetten sowas wie dich einfach verspeist, nur gut, dass ich sowas fettiges nicht esse!\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.VERABSCHIEDUNG)) {
                logger.info("Ja verzeih dich endlich, dein Anblick ist eine Qual fuer meine Augen und meine Seele.\n");
                imGespreach=false;
            }
            if (ausgewaehlt.equals(DialogAntwortArt.KOMPLIMENT)) {
                logger.info("Denkst du jetzt etwa du kannst dich einschleimen?\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.FLIRTEN)) {
                logger.info("AHAHAH du spielst nicht in meiner Liga, versuchs mal bei den Goblins du Gesichtsgraetsche\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.BETTELN)) {
                logger.info("So etwas erbaermliches ist mir schon lange nicht mehr unter gekommen.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.QUATSCH)) {
                logger.info("Welch eine Befriedigung zu sehen, dass die Kommunikation intelligenten Wesen wie mir vorbehalten ist.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.STUMM)) {
                logger.info("Langsam reicht es Freundchen, du verschwaendest meine Zeit.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.GEWONNEN)) {
                logger.info("Toll du bist nichts ganz dumm. Du hast das Raetsel geloest.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.RATEN)) {
                Random r = new Random();
                int minimum=0;
                int lanege=getZitate().length;
                int z = minimum+r.nextInt(lanege-minimum+1);
                logger.info("\n"+getZitate()[z-1]+"\n\n");
            }
        }
    }
}
