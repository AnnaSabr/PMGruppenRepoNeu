package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;

/**
 * Factory Klasse der Npcs
 */
public class NpcCreator {

    private NpcCreator(){}

    /**
     * je nach uergebenen Paramter wird ein Npc erstellt
     *
     * @param bewegung wird nicht gerbaucht
     * @param lebenspunkte wird nicht gerbaucht
     * @param staerke wird nicht gerbaucht
     * @param geschwindigkeit wird nicht gerbaucht
     * @param npcName entscheidet welcher Npc erstellt wird
     * @param painter irgendwas mit Grafik
     * @param batch irgendwas mit Grafik
     * @return den neuen Npc
     */
    public static Npc getNpc(FigurenBewegung bewegung, int lebenspunkte, int staerke, float geschwindigkeit, ENpcs npcName, Painter painter, SpriteBatch batch){
        if (npcName==ENpcs.ELF){
            NpcHaendler elf = new NpcHaendler(bewegung,lebenspunkte,staerke,geschwindigkeit,painter,batch);
            return elf;
        }
        if (npcName==ENpcs.LIZARD){
            NpcLizard lizard = new NpcLizard(bewegung,lebenspunkte,staerke,geschwindigkeit,painter,batch);
            return lizard;
        }
        return null;
    }
}
