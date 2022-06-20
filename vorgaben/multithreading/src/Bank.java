import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Bank  {

    private static Logger logger = Logger.getLogger(Bank.class.getName());

    /**
     * Ueberweise Geld von einem Konto auf das andere
     *
     * @param von Konto von dem das Geld gesendet wird
     * @param rechnung Die Rechnung die bezahlt werden muss
     */
    public static void ueberweisen(Konto von, Rechnung rechnung) {
        Transaktion transaktion = new Transaktion(von, rechnung);
        ExecutorService single = Executors.newSingleThreadExecutor();
        single.execute(transaktion);
        logger.info(Thread.currentThread().getName()+" hat gerade eine transaktion ausgeloest.");
        single.shutdown();
    }
}
