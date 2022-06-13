import java.util.logging.Logger;

public class Bank {

    Logger logger = Logger.getLogger(Bank.class.getName());
    private float gesamtZinsen=0f;

    /**
     *  berechnet abhaengig von Alter und Guthaben den gesamtZinsatzes eines Kunden
     * @param mensch der Kunde von dem die Zinsen berechnet werden sollen
     * @return den Gesamtzinsatz des Kunden
     */
    public float gesamtZinssatz(Kunde mensch){
        if (mensch.getAlter()>=0){
            if (mensch.getGuthaben()>0&&mensch.getGuthaben()<101){
                gesamtZinsen=1f;
            }
            else if (mensch.getGuthaben()>100&&mensch.getGuthaben()<1001){
                gesamtZinsen=3f;
            }
            else if (mensch.getGuthaben()>1000){
                gesamtZinsen=5f;
            }
            else{
                logger.warning("Es befindet sich kein Geld auf Ihrem Konto, oder Sie sind im Minus.");
            }
            if (mensch.getAlter()<5){
                gesamtZinsen+=0.5f;
            }
            else if (mensch.getAlter()>64){
                gesamtZinsen+=1f;
            }
            else{
                logger.info("Sie sind altersbedingt nicht berechtigt fuer einen weiteren Bonus.");
            }
        }
        else{
            logger.warning("Ungueltiges Alter");
        }

        return gesamtZinsen;
    }
}
