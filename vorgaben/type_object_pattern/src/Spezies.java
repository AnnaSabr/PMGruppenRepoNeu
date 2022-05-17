public class Spezies {

    private final String variety;
    private final int magic;
    private final int xp;


    /**
     *
     * @param variety des aktuellen Monsters
     * @param magic des aktuellen Monsters
     * @param xp des aktuellen Monsters
     */
    public Spezies( String variety,int magic, int xp){
        this.magic=magic;
        this.variety=variety;
        this.xp=xp;
    }

    /**
     *
     * @return das aktuelle Monsterobjekt
     */
    public Monster getMonster() {
        return new Monster(this);
    }

    /**
     *
     * @return je nach xp Wert werden unterschiedliche Geraeusche zurueck gegeben
     */
    public String makeNoise(){
        String ton;
        if (xp>10){
            ton="weeeee";
        }
        else{
            ton ="arghhh";
        }
        return ton;
    }

    /**
     *
     * @return die variety von dem Monster
     */
    public String getVariety() {
        return variety;
    }

    /**
     *
     * @return magiv von dem Monster
     */
    public int getMagic() {
        return magic;
    }

    /**
     *
     * @return xp von dem Monster
     */
    public int getXp() {
        return xp;
    }
}
