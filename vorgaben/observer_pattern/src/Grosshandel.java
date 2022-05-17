import java.util.logging.Logger;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Grosshandel implements IObservarble{
    private HashMap<WarenTyp, Integer> lager;
    private Map<WarenTyp, Collection<IObserver>> customers;
    private Auftrag newOffer;
    private static final Logger log = Logger.getLogger(Grosshandel.class.getName());

    public Grosshandel() {
        lager = new HashMap<>();
        this.customers = new HashMap<>();
        for (WarenTyp typ : WarenTyp.values()) {
            lager.put(typ, 0);
            this.customers.put(typ, new HashSet<IObserver>());
        }
    }

    /**
     * Ein Einzelhändler kann Waren mit einer bestimmten Anzahl bestellen. Wenn
     * diese in ausreichender Zahl verfügbar ist, liefert der Großhandel die
     * gewünschte Ware direkt aus.
     *
     * @param kunde   Der Kunde, welcher die Bestellung tätigt.
     * @param auftrag Der Auftrag, welcher abgearbeitet werden soll.
     */
    public void bestellen(Einzelhandel kunde, Auftrag auftrag) {
        log.info("start ordering");
        if (lager.containsKey(auftrag.getWarenTyp())) {
            int diff = lager.get(auftrag.getWarenTyp()) - auftrag.getAnzahl();
            log.info("diff : " + diff);
            if(diff > 0) {
                this.newOffer = new Auftrag(auftrag.getWarenTyp(), diff);
                lager.put(auftrag.getWarenTyp(), diff);
                kunde.empfangen(auftrag);
            }
        }
        log.info("end ordering");
    }

    @Override
    public Auftrag getRessource() {
        return this.newOffer;
    }

    /**
     * Der Grosshandel bekommt immer Ware, von der am wenigsten aktuell verfügbar
     * ist und informiert seine Kunden darüber.
     */
    public void loop() {
        Random random = new Random();
        Map.Entry<WarenTyp, Integer> kleinsterBestand = findeKleinstenBestand();
        int zusatzMenge = random.nextInt(1, 5);
        kleinsterBestand.setValue(kleinsterBestand.getValue() + zusatzMenge);
        //Observer Pattern
        this.newOffer = new Auftrag(kleinsterBestand.getKey(), kleinsterBestand.getValue());
        this.notifyObservers();
    }

    private Map.Entry<WarenTyp, Integer> findeKleinstenBestand() {
        Map.Entry<WarenTyp, Integer> kleinsterBestand = null;
        for (Map.Entry<WarenTyp, Integer> loop : lager.entrySet()) {
            if (kleinsterBestand == null || kleinsterBestand.getValue() > loop.getValue()) {
                kleinsterBestand = loop;
            }
        }
        return kleinsterBestand;
    }

    @Override
    public void notifyObservers() {
        log.info("start notifying observers");
        Iterator<IObserver> observerIterator = this.customers.get(this.newOffer.getWarenTyp()).iterator();
        while(observerIterator.hasNext() && this.newOffer.getAnzahl() > 0) {
            observerIterator.next().update();
        }
        log.info("end notifying observers");
    }

    @Override
    public void register(IObserver o, WarenTyp type) {
        log.info("register methode get " + type.toString()+ " as type");
        this.customers.get(type).add(o);
    }
}
