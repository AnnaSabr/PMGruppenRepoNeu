package desktop;

interface ISkillResource {
    
    /**
     * Diese Methode soll die Ressourcen für eine Fähigkeit aufbrauchen und liefert true wenn dafür noch genug Ressourcen vorhanden sind. Sonst wird false zurüchgegeben.
     */
    public boolean getResource();
}
