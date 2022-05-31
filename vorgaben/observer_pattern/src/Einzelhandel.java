import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Einzelhandel implements IObserver{
    private HashMap<WarenTyp, Integer> lager;
    private Grosshandel grosshandel;
    private List<Auftrag> auftraege;
    private Set<WarenTyp> assortment;
    private static final Logger log = Logger.getLogger(Einzelhandel.class.getName());

    @Deprecated

    public Einzelhandel(Grosshandel grosshandel) {
        lager = new HashMap<>();
        auftraege = new ArrayList<>();
        this.grosshandel = grosshandel;

        this.assortment = new HashSet<>();
        this.assortment.add(WarenTyp.Bretter);
        this.assortment.add(WarenTyp.Batterien);
        this.assortment.add(WarenTyp.Farbeimer);
        this.registerAsObserver();
    }

    public Einzelhandel(Grosshandel grosshandel, Set<WarenTyp> assortment) {
        this.lager = new HashMap<>();
        this.auftraege = new ArrayList<>();
        this.grosshandel = grosshandel;
        this.assortment = assortment;
        this.registerAsObserver();
    }

    private void registerAsObserver() {
        log.info("start register as observer");
        if(this.grosshandel instanceof IObservarble){
            log.info(" Groshandel is IObservarble");
            IObservarble observarble = (IObservarble) this.grosshandel;
            Iterator<WarenTyp> iterator = this.assortment.iterator();
            while(iterator.hasNext()){
                observarble.register(this, iterator.next());
            } 
        }
        log.info("end register as observer");
    }

    /**
     * Kunde bestellt Ware: Speichere den Auftrag ab und versuche später
     * in <code>loop()</code>, den Auftrag beim Großhandel zu bestellen.
     *
     * @param auftrag der Auftrag, der aufgenommen werden soll.

     * @return true wenn der Auftrag erfolgreich beaebeitet wurde, sonst false
     */
    public boolean bestellen(Auftrag auftrag) {
        if(this.assortment.contains(auftrag.getWarenTyp()) && auftrag.getAnzahl() > 0){
            auftraege.add(auftrag);
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * Empfange Ware vom Großhandel, füge die Ware dem Lager hinzu und
     * entferne den offenen Auftrag.
     *
     * @param auftrag der Auftrag, der abgearbeitet werden soll.
     */
    public void empfangen(Auftrag auftrag) {
        lager.put(auftrag.getWarenTyp(), lager.getOrDefault(auftrag.getWarenTyp(), 0) + auftrag.getAnzahl());
        auftraege.remove(auftrag);
    }

    /**
     * Versuche alle Aufträge durch Bestellung beim Großhandel abzuschließen.
     */

    @Deprecated
     public void loop() {
        for (int i = auftraege.size(); i > 0; i--) {
            Auftrag auftrag = auftraege.get(i - 1);
            grosshandel.bestellen(this, auftrag);
        }
    }

    /**
     * Existieren beim Einzelhändler noch offene Aufträge?
     *
     * @return true wenn mehr als 1 Auftrag offen ist, sonst false
     */

    @Deprecated
     public boolean hatAuftraege() {
        return auftraege.size() > 0;
    }

    @Override
    public void update() {
        log.info("start update");
        if(this.grosshandel instanceof IObservarble){
            IObservarble observarble = (IObservarble) this.grosshandel;
            Auftrag offer = observarble.getRessource();
            if(this.assortment.contains(offer.getWarenTyp()) && this.hatAuftraege()) {
                Iterator<Auftrag> iterator = this.auftraege.iterator();
                while(iterator.hasNext()) {
                    Auftrag order = iterator.next();
                    log.info("need: " + order.getAnzahl() + " x " + order.getWarenTyp().toString() + "\nget: " + offer.getAnzahl() + " x " + offer.getWarenTyp().toString());
                    //ob die anfrage gueltig ist wird auch im observerbal ueberprueft ...
                    if(offer.getWarenTyp() == order.getWarenTyp() && offer.getAnzahl() >= order.getAnzahl()) {
                        grosshandel.bestellen(this, order);
                        offer = observarble.getRessource();//update offer because the amout would change by ordering
                    }
                }
            }
        }
        log.info("end update");
    }

}
