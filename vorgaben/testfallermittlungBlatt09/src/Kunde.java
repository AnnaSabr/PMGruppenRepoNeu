public class Kunde {

    private String name;
    private int alter;
    private int guthaben;

    /**
     *
     * @param name des jeweiligen Kunden
     * @param alter des jeweiligen Kunden
     * @param guthaben des jeweiligen Kunden
     */
    public Kunde (String name, int alter, int guthaben){
        this.name=name;
        this.alter=alter;
        this.guthaben=guthaben;
    }

    /**
     *
     * @return das Alter des Kunden
     */
    public int getAlter(){
        return this.alter;
    }

    /**
     *
     * @return das Guthaben des Kunden
     */
    public int getGuthaben(){
        return this.guthaben;
    }
}
