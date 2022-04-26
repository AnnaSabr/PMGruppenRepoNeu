package zoo;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Zoo<T extends Gehege<?>> {

    ArrayList<T> liste = new ArrayList<>();
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Fuegt ein Gehege dem Zoo hinzu
     * @param gehege Gehege welches hinzugefuegt werden soll
     */
    public void errichten(T gehege) {

        int count = 0;
        for (T element : liste) {
            if (element.getClass().isInstance(gehege.getClass())) { // der shit funktioniert nicht
                count++;
            }

        }
        if (count == 0) {
            liste.add(gehege);
        } else {
            logger.warning("Es existiert bereits ein Gehege mit dieser Art im Zoo.\n");
        }
        ausgeben();
        logger.config("\n");
    }

    /**
     * Entfernt ein Gehege aus dem Zoo, wenn vorhanden
     * @param gehege Gehege welches entfernt weden soll
     */
    public void abreissen(T gehege) {
        if (liste.contains(gehege)) {
            liste.remove(gehege);
        } else {
            logger.warning("So ein Gehege gibt es nicht im Zoo.\n");
        }
        ausgeben();
        logger.config("\n\n");
    }

    /**
     * Gibt die aktuellen Gehege des Zoos aus
     */
    public void ausgeben() {
        logger.setLevel(Level.ALL);
        for (T element : liste) {
            logger.info(element.getName() + " " + element.getClass().getSimpleName());
        }
        logger.config("\n\n");
    }
}
