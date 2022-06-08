package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;

/**
 * Ist die Factory Klasse des FactoryPattern
 */
public class MonsterCreator {

    private MonsterCreator() {
    }

    /**
     * Wenn zwei Monster ich sehr lieb haben und ein neues Monster das trostlose Licht der Welt erblickt
     *
     * @param staerke  staerke des Monsters
     * @param geschwindigkeit geschwindigkeit des Monsters
     * @param lebenspunkte lebenspunkte des Monsters
     * @param monsterName Art des Monsters
     * @param painter irgednwas mit Texturen
     * @param batch auch irgendwas mit Texturen
     * @return gibt das gezeugte Monster zurueck
     */
    public static Monster getMonster(FigurenBewegung bewegung, int staerke, float geschwindigkeit, int lebenspunkte, EMonster monsterName, Painter painter, SpriteBatch batch) {
        if (monsterName == EMonster.SKELET) {
            Skelet knochen = new Skelet(bewegung,staerke,geschwindigkeit,lebenspunkte,painter, batch);
            return knochen;
        }
        if (monsterName == EMonster.NECROMANT) {
            Necromant tot = new Necromant(bewegung,staerke,geschwindigkeit,lebenspunkte,painter, batch);
            return tot;
        }
        return null;
    }
}