package desktop;

public interface QuestObservable {

    /**
     *
     * @param questObserver
     */
    void register(QuestObserver questObserver);

    void unregister(QuestObserver questObserver);

    void notifyObservers();
}
