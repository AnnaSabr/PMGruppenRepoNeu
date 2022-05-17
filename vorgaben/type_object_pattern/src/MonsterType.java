public enum MonsterType {
    ORK("ork", 2, 10),
    ELB("elb", 21, 12),
    ZWERG("zwerg", 6, 8);

    private final String variety;
    private final int magic;
    private final int xp;

    /**
     *
     * @param var variety des Monsters
     * @param magic des aktuellen Monsters
     * @param xp des aktuellen monsters
     */
    MonsterType(String var, int magic, int xp) {
        this.variety = var;
        this.magic = magic;
        this.xp = xp;
    }

    /**
     *
     * @return gibt je nach xp einen sound aus
     */
    public String makeNoise() {
        String ton;
        if (xp > 10) {
            ton = "weeeee";
        } else {
            ton = "arghhh";
        }
        return ton;
    }

    /**
     *
     * @return die variety des Monsters
     */
    public String getVariety() {
        return variety;
    }

    /**
     *
     * @return den magic Wert des Monsters
     */
    public int getMagic() {
        return magic;
    }

    /**
     *
     * @return die xp des Monsters
     */
    public int getXp() {
        return xp;
    }
}
