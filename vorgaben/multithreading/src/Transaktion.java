import java.util.logging.Logger;

/**
 * Eine Transaktion bearbeitet eine Rechnung
 *
 * @param von Konto von dem aus die Rechnung bezahlt werden soll
 * @param rechnung Die zu bezahlende Rechnung
 */
public record Transaktion(Konto von, Rechnung rechnung) implements Runnable{


    public synchronized void doTransaktion(){
        Logger logger=Logger.getLogger(this.getClass().getName());
        if(von.sendeGeld(rechnung().betrag())){
            rechnung.empfaenger().empfangeGeld(rechnung().betrag());
            logger.info(Thread.currentThread().getName()+" hat gerade Geld gesendet und empfangen.");
        }
    }

    @Override
    public void run(){
            doTransaktion();
    }
}
