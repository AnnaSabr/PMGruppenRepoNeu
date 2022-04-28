package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;

public class MonsterCreator {

    private MonsterCreator() {
    }

    public static Monster getMonster(int staerke, float geschwindigkeit, int lebenspunkte, EMonster monsterName, Painter painter, SpriteBatch batch) {
        if (monsterName == EMonster.SKELET) {
            Skelet knochen = new Skelet(staerke,geschwindigkeit,lebenspunkte,painter, batch);
            return knochen;
        }
        if (monsterName == EMonster.NECROMANT) {
            Necromant tot = new Necromant(staerke,geschwindigkeit,lebenspunkte,painter, batch);
            return tot;
        }
        return null;
    }
}
