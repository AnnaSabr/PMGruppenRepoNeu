package desktop;

import graphic.Animation;
import tools.Point;

import java.util.Random;
import java.util.logging.Logger;

/**
 * AnimationsArt fuer einen NPC der sich langsam bewegt
 */
public class NpcWandern implements FigurenBewegung{

    MyHero hero;
    Logger logger= Logger.getLogger(NpcWandern.class.getName());

    public NpcWandern(MyHero hero){
        this.hero=hero;
    }

    @Override
    public void bewegen(Figuren figur) {
        Point newPosition = new Point(figur.getPosition());
        float movementSpeed = 0.3f;
        Random ran = new Random();


        int r = ran.nextInt(4);
        if (r == 0) {
            newPosition.y += movementSpeed;
        }
        if (r == 1) {
            newPosition.x -= movementSpeed;
        }
        if (r == 2) {
            newPosition.x += movementSpeed;
        }
        if (r == 3) {
            newPosition.y -= movementSpeed;
        }
        if (figur.getLevel().getTileAt(newPosition.toCoordinate()).isAccessible()) {
            figur.setPosition(newPosition);
            if (r == 1 | r == 2) {
                figur.setIdleAnimation(new Animation(figur.getLinks(), 10));
            }
            if (r == 0 | r == 3) {
                figur.setIdleAnimation(new Animation(figur.getRechts(), 10));
            }
        }
        double distanz=Math.sqrt(Math.pow(figur.getPosition().x-hero.getPosition().x,2.0)+Math.pow(figur.getPosition().y-hero.getPosition().y,2.0));
        if (distanz<3){
            if (figur.getTime()%300==0){
                logger.info("Du machst das absolut grauenhaft, jeder andere waere schon tausendmal schneller durch mit dem Spiel.");
            }
        }
    }
}
