package desktop;

interface ISkillUser {
    /**
     * Diese Methode weist dem Objekt eine gewünschte Fähigkeit zu.
     * 
     * @param ISkill skill, gewünschte Fähigkeit.
     */
    public void equipSkill(ISkill skill);

    /**
     * Diese Methode lässt das Objekt mit anderen Objekten interagieren.
     */
    public void useSkill();
}
