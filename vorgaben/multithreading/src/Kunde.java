import java.util.*;
import java.util.logging.Logger;

public class Kunde implements Runnable {
    private Konto konto;
    private Queue<Rechnung> offeneRechnungen;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * Erstelle einen neune Kunden, der sich ein Konto bei der Bank erstellt.
     */
    public Kunde() {
        konto = new Konto();
        offeneRechnungen = new LinkedList<>();
    }

    /**
     * Empfange eine Rechnung zum bezahlen.
     *
     * @param rechnung Die Rechnung.
     */
    public void empfangeRechnung(Rechnung rechnung) {
        offeneRechnungen.add(rechnung);
        synchronized (this) {
            notify();
            logger.info("Nooooooootify");
        }
    }

    /**
     *
     * @return das Konto des Kunden
     */
    public Konto getKonto() {
        return konto;
    }

    @Override
    public void run() {
        synchronized (this) {
            boolean endlos = true;
            while (endlos) {
                Rechnung rechnung = offeneRechnungen.peek();
                while (rechnung == null) {
                    try {
                        this.wait();
                        logger.info(Thread.currentThread().getName() + " wartet gerade.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    rechnung = offeneRechnungen.peek();
                }
                rechnung = offeneRechnungen.remove();
                Bank.ueberweisen(konto, rechnung);
                logger.info(Thread.currentThread().getName() + " startet eine Ueberweisung.");
            }
        }
    }
}
