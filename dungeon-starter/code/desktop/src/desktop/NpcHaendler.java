package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Animation;
import graphic.Painter;

import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Spezieller NPC der fuer die Haendler Funktion vorgesehen ist
 */
public class NpcHaendler extends Npc {
    private Key key;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public NpcHaendler(FigurenBewegung bewegung, int lebenspunkte, int staerke, float geschwindigkeit, Painter painter, SpriteBatch batch) {
        super(bewegung, lebenspunkte, staerke, geschwindigkeit, painter, batch);

        this.key = new Key(painter, batch);

        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f0.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f1.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f2.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f3.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f0l.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f1l.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f2l.png");
        getAnimation().add("npcs/elf/idle/elf_m_idle_anim_f3l.png");
        setIdleAnimation(new Animation(getAnimation(), 6));


    }

    /**
     * @return gibt das erstelle Item zurueck
     */
    public Key getKey() {
        return this.key;
    }

    @Override
    public void update() {
        if (getTime() % 50 == 0) {
            bewegen();
        }
        setTime(getTime() + 1);

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
                logger.info("Einen wunderschönen guten Tag, ich hoffe dir geht es gut.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.BELEIDIGUNG)) {
                logger.info("Oh das war jetzt aber nicht sehr nett von dir. :(\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.VERABSCHIEDUNG)) {
                logger.info("Eine sichere Reise dir und ich hoffe wir sehen uns bald wieder.\n");
                imGespreach = false;
            }
            if (ausgewaehlt.equals(DialogAntwortArt.KOMPLIMENT)) {
                logger.info("Vielen dank! Das gleiche gilt fuer dich.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.FLIRTEN)) {
                logger.info("Oh bitte, ich werde schon ganz rot.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.BETTELN)) {
                logger.info("Tut mir leid, ich kann dir leider nichts geben.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.QUATSCH)) {
                logger.info("Ich bin auch immer nervoeus, wenn ich mit neuen Leuten rede. Komm versuch es nochmal.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.STUMM)) {
                logger.info("Stille ist so wichtig fuer den inneren Frieden, lass uns der Nature lauschen.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.GEWONNEN)) {
                logger.info("Wow du bist so schlau! Beeindruckende Leistung.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.RATEN)) {
               Random r = new Random();
               int minimum=0;
               int lanege=getZitate().length;
               int z = minimum+r.nextInt(lanege-minimum)+1;
               logger.info("\n"+getZitate()[z-1]+"\n\n");
            }
        }
    }
}
