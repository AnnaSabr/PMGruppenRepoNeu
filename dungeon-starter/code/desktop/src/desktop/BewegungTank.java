package desktop;

import graphic.Animation;
import tools.Point;

import java.util.Random;

/**
 * Das Beewgungsmuster fuer den Boss "Tank"
 */
public class BewegungTank implements FigurenBewegung {

    MyHero hero;


    public BewegungTank(MyHero hero){
        this.hero=hero;
    }

    @Override
    public void bewegen(Figuren bossMonster){
        Point newPosition = new Point(bossMonster.getPosition());
        float movementSpeed= bossMonster.getGeschwindigkeit();
        if (bossMonster.getLebenspunkte()<bossMonster.getGesamtesLeben()/2){
            movementSpeed = 0.4f;

            if (hero.getPosition().x > bossMonster.getPosition().x) {
                newPosition.x += movementSpeed;
            } else if (hero.getPosition().x < bossMonster.getPosition().x) {
                newPosition.x -= movementSpeed;
            }
            if (hero.getPosition().y > bossMonster.getPosition().y) {
                newPosition.y += movementSpeed;
            } else if (hero.getPosition().y < bossMonster.getPosition().y) {
                newPosition.y -= movementSpeed;
            }

            if (bossMonster.getLevel().getTileAt(newPosition.toCoordinate()).isAccessible()) {
                bossMonster.setPosition(newPosition);
            }
        }
        else{
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
            if (bossMonster.getLevel().getTileAt(newPosition.toCoordinate()).isAccessible()) {
                bossMonster.setPosition(newPosition);
                if (r == 1 | r == 2) {
                    bossMonster.setIdleAnimation(new Animation(bossMonster.getLinks(), 10));
                }
                if (r == 0 | r == 3) {
                    bossMonster.setIdleAnimation(new Animation(bossMonster.getRechts(), 10));
                }
            }
        }
    }
}
