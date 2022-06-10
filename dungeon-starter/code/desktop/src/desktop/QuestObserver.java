package desktop;

public interface QuestObserver {

    /**
     * update-Methode des Observer-Patterns für Quests, informiert Quests über neue Items im Inventarddddw
     */
    void questUpdate(Inventar inventar);
}
