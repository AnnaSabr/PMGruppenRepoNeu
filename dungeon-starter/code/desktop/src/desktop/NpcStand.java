package desktop;

import tools.Point;

import java.util.logging.Logger;

/**
 * AnimationsArt fuer einen NPC der nur stehen soll
 */
public class NpcStand implements FigurenBewegung {


    private Figuren figur;
    private MyHero hero;
    private Logger logger = Logger.getLogger(NpcStand.class.getName());
    private boolean uebergeben = false;

    public NpcStand(MyHero hero) {
        this.hero = hero;
    }

    @Override
    public void bewegen(Figuren figur) {
        this.figur = figur;
        if (figur.getTime() % 1000 == 0) {
            Point newPosition = new Point(figur.getLevel().getRandomFloorTile().getCoordinate().toPoint());
            figur.setPosition(newPosition);
        }
        double distanz = Math.sqrt(Math.pow(figur.getPosition().x - hero.getPosition().x, 2.0) + Math.pow(figur.getPosition().y - hero.getPosition().y, 2.0));
        if (distanz < 3) {
            if (uebergeben == false) {
                logger.info("Hier du Looser ein extra Item damit du nicht noch mehr verlierst.");
                NpcHaendler haendler = (NpcHaendler) figur;
                MyHero.itemInventar.hinzufuegen(haendler.getKey());
                uebergeben = true;
            }
            if (uebergeben == true) {
                if (figur.getTime() % 50 == 0) {
                    logger.info("Du hast dein Item schon erhalten, hoer auf zu geiern.");
                }
            }
        }
    }
}

