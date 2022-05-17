public interface IObserver {
    /**
     * Gibt den Observern an dass sich die Ressourcen geändert haben 
     * @param type
     * @param amount
     */
    public void update();
}
