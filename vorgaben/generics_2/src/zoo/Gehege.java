package zoo;

import zoo.tiere.Tier;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Gehege<T extends Tier> {
    String gehegeName;
    ArrayList<T> liste = new ArrayList<>();
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * gibt den Names des Geheges zurueck
     * @param namen erhaelt namen der Unterklasse
     */
    public Gehege(String namen) {
        gehegeName = namen;
    }

    /**
     * Nimmt ein Tier in das Gehege auf, wenn noch nicht vorhanden
     * @param tier Tier das aufgenommen werden soll
     */
    public void aufnehmen(T tier) {
        int count = 0;
        for (T element : liste) {
            if (tier.getClass() == element.getClass()) {
                count++;
            }
        }
        if (count == 0) {
            liste.add(tier);
        } else {
            logger.warning("Es existiert bereits ein Tier dieser Art im Gehege.\n");
        }
        ausgeben();
        logger.config("\n\n");
    }

    /**
     * entfertn das Tier aus dem Gehege, wenn vorhanden
     * @param tier Tier das entfernt werden soll
     */
    public void entfernen(T tier) {
        if (liste.contains(tier)) {
            liste.remove(tier);
        } else {
            logger.warning("Das Tier ist nicht in der Liste enthalten.\n");
        }
        ausgeben();
        logger.config("\n\n");
    }

    /**
     * gibt die aktuellen Tiere im Gehege aus
     */
    public void ausgeben() {
        logger.setLevel(Level.ALL);
        for (T element : liste) {
            logger.info(element.getName() + " " + element.getClass().getSimpleName());
        }
        logger.config("\n\n");

    }

    /**
     * Gibt den Namen des Gehges zurueck
     * @return Namen des Geheges
     */
    public String getName() {
        return gehegeName;
    }


}
