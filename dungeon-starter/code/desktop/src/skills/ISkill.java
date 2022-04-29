package desktop;

interface ISkill {
    /**
     *  Diese Methode soll zunächst dafür benutzt werden um Status Information in einem String anzulegen. Es ist geplant diese dann mit einem User Interface zu verbinden.
     * 
     * @return Status Informationen
     */
    public String display();

    /**
     * Diese Methode schaltet die Fähigkeit zur Benutzung frei. 
     */
    public void unlock();

    /**
     * Diese Methode lässt Objekte miteinander interagieren, dabei ist es ist von der jeweiligen Fähigkeit abhängig welche Objekte betroffen sind.
     */
    public void use();

    /**
     * Diese Methode aktualisiert die CoolDown Zeit.
     */
    public void update();
}
