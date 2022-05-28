import java.util.logging.Logger;

public class Tintendrucker extends Drucker{

    Logger logger = Logger.getLogger(Tintendrucker.class.getName());
    @Override
    public void scannen() {
        logger.info("Scanne das Dokument mit dem Tintendrucker.");

    }

    @Override
    public void drucken() {
        logger.info("Drucke das Dokument auf dem Tintendrucker.");

    }

    public static void main (String[]args){
        Tintendrucker tintendrucker = new Tintendrucker();
        tintendrucker.kopieren();

        Laserdrucker laserdrucker = new Laserdrucker();
        laserdrucker.kopieren();
    }
}
