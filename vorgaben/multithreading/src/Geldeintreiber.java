import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * erstellt Rechnungen und verteilt sie an Kunden
 */
public class Geldeintreiber implements Runnable {

    Kunde k;
    List<Kunde> kunden;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public Geldeintreiber(Kunde k, List<Kunde> kunden){
        this.k=k;
        this.kunden=kunden;
    }

    @Override
    public void run(){
        Random random = new Random();
        Kunde halter = kunden.get(random.nextInt(kunden.size()));
        while (halter==k){
            halter=kunden.get(random.nextInt(kunden.size()));
        }

        Rechnung rechnung= new Rechnung(66,k.getKonto());
        logger.info(Thread.currentThread().getName()+" hat eine Rechnung geschickt.");
        halter.empfangeRechnung(rechnung);

        try{
            TimeUnit.SECONDS.sleep(5);
            logger.info(Thread.currentThread().getName()+" hat 5 Sekunden geschlafen.");
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
