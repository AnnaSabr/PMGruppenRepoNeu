import java.util.logging.Logger;

public class Laserdrucker extends Drucker{

    Logger logger = Logger.getLogger(Laserdrucker.class.getName());
    @Override
    public void scannen() {
        logger.info("Scanne das Dokument mit dem Laserdrucker.");

    }

    @Override
    public void drucken() {
        logger.info("Drucke das Dokument auf dem Laserdrucker.");

    }
}
