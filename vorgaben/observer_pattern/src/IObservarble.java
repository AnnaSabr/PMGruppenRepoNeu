public interface IObservarble {
    
    /**
     * Setzt den angegebenen Observer auf eine den WarenTyp entprechende Liste
     * @param o
     * @param type
     */
    public void register(IObserver o, WarenTyp type);

    public Auftrag getRessource();
    
    /**
     * Abhaengig von der Ressource werden die Observer in der entprechenden List informiert, indem die update methode aufgerufen wird
     */
    public void notifyObservers();
}
