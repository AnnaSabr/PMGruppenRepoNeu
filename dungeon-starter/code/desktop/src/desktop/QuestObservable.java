package desktop;

public interface QuestObservable {

    /**
     * speichert Objekte, die benachrichtigt werden sollen
     *
     * @param questObserver soll hinzugefügt werden
     */
    void register(QuestObserver questObserver);

    /**
     * entfernt Objekte, die nicht mehr benachrichtigt werden sollen
     *
     * @param questObserver soll entfernt werden
     */
    void unregister(QuestObserver questObserver);

    /**
     * benachrichtigt Observer über Veränderungen
     */
    void notifyObservers();
}
