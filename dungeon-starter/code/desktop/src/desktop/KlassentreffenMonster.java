package desktop;

import level.elements.room.Tile;
import tools.Point;

/**
 * Bewegung der Monster die alle nur eine Zielpositon im Dungeon haben
 */
public class KlassentreffenMonster implements FigurenBewegung {
    Tile ziel;

    public KlassentreffenMonster(MyHero hero){
         ziel=hero.getLevel().getRandomRoom().getRandomFloorTile();
    }

    @Override
    public void bewegen(Figuren monster){
        float movementSpeed = 0.3f;
        Point newPosition = new Point(monster.getPosition());

        if (ziel.getCoordinate().toPoint().x>monster.getPosition().x){
            newPosition.x += movementSpeed;
        }
        else if (ziel.getCoordinate().toPoint().x < monster.getPosition().x) {
            newPosition.x -= movementSpeed;
        }

        if (ziel.getCoordinate().toPoint().y > monster.getPosition().y) {
            newPosition.y += movementSpeed;
        }
        else if (ziel.getCoordinate().toPoint().y < monster.getPosition().y) {
            newPosition.y -= movementSpeed;
        }

        if (monster.getLevel().getTileAt(newPosition.toCoordinate()).isAccessible()) {
            monster.setPosition(newPosition);
        }


    }
}
