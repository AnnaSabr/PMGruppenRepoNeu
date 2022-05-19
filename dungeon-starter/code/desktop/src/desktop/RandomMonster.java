package desktop;

import graphic.Animation;
import tools.Point;

import java.util.Random;

/**
 * Bewegung fuer Monster die Random durch den Raum laufen
 */
public class RandomMonster implements MonsterBewegung{

    @Override
    public void bewegen(Monster monster) {
        Point newPosition = new Point(monster.getPosition());
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
        if (monster.getLevel().getTileAt(newPosition.toCoordinate()).isAccessible()) {
            monster.setPosition(newPosition);
            if (r == 1 | r == 2) {
                monster.setIdleAnimation(new Animation(monster.getlinks(), 10));
            }
            if (r == 0 | r == 3) {
                monster.setIdleAnimation(new Animation(monster.getNichtLinks(), 10));
            }
        }
    }

}
