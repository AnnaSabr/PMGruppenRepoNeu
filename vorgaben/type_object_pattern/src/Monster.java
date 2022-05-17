public class Monster implements IMonster{

    private final Spezies type;
    private int xp;


    /**
     *
     * @param type setzt die xp und den Monstertyp
     */
    public Monster(Spezies type){
        this.type=type;
        this.xp=type.getXp();
    }

    @Override
    public String getVariety() {
        return type.getVariety();
    }

    @Override
    public int getXp() {
        return type.getXp();
    }

    @Override
    public int getMagic() {
        return type.getMagic();
    }

    @Override
    public String makeNoise() {
        return type.makeNoise();
    }

    /**
     * Gibt die Werte eines Monsters auf der Konsole aus
     */
    public void ausgabe(){
        System.out.println("Variety: "+this.type.getVariety()+",\n" +
            "Magic: "+this.type.getMagic()+"\n" +
            "xp: "+this.getXp()+"\n" +
            "Noise: "+this.type.makeNoise()+"\n\n");
    }


    public static void main (String[]args){

        final Spezies ORK = new Spezies("Ork",1,9);
        final Spezies ELB = new Spezies("Elb",20,11);
        final Spezies ZWERG = new Spezies("Zwerg",5,9);


        Monster grischnakh = ORK.getMonster();
        Monster galadriel = ELB.getMonster();
        Monster gimli = ZWERG.getMonster();

        grischnakh.ausgabe();
        galadriel.ausgabe();
        gimli.ausgabe();
    }
}
