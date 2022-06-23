package desktop;


import tools.Point;


/**
 * Bewegung fuer Monster, die auf den Helden zulaufen
 */
public class WillKuscheLnMonster implements FigurenBewegung {

    MyHero hero;

    /**
     *
     * @param hero unser Held
     */
    public WillKuscheLnMonster(MyHero hero) {
        this.hero = hero;
    }

    @Override
    public void bewegen(Figuren monster) {
        float movementSpeed = 0.3f;
        Point posiMonster = monster.getPosition();
        Point posiHero = hero.getPosition();
        Point newPosition = new Point(posiMonster);
        if (hero.getPosition().x > monster.getPosition().x) {
            newPosition.x += movementSpeed;
        } else if (hero.getPosition().x < monster.getPosition().x) {
            newPosition.x -= movementSpeed;
        }
        if (hero.getPosition().y > monster.getPosition().y) {
            newPosition.y += movementSpeed;
        } else if (hero.getPosition().y < monster.getPosition().y) {
            newPosition.y -= movementSpeed;
        }

        if (monster.getLevel().getTileAt(newPosition.toCoordinate()).isAccessible()) {
            monster.setPosition(newPosition);
        }
    }
}
