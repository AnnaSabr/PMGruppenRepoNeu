package zoo;

import zoo.tiere.fische.Fisch;
import zoo.tiere.fische.Salzwasserfisch;
import zoo.tiere.fische.Sueszwasserfisch;
import zoo.tiere.saeuger.katzen.Katze;
import zoo.tiere.saeuger.katzen.Loewe;
import zoo.tiere.saeuger.katzen.Tiger;
import zoo.tiere.saeuger.nager.Hamster;
import zoo.tiere.saeuger.nager.Kaninchen;
import zoo.tiere.saeuger.nager.Nager;

public class Main {
    public static void main(String[] args) {
        Gehege<Nager> eins = new Gehege<>("Fellknaeul");
        Gehege<Katze> zwei = new Gehege<>("MiezMiez");

        Hamster bob = new Hamster("Bob");
        Hamster guntehr = new Hamster("Guntehr");
        Kaninchen bonny = new Kaninchen("Bonny");
        Kaninchen hops = new Kaninchen("Hops");

        eins.aufnehmen(bob);
        eins.aufnehmen(guntehr);
        eins.aufnehmen(bonny);
        eins.entfernen(hops);
        eins.aufnehmen(hops);
        eins.entfernen(hops);

        Loewe leo = new Loewe("Leo");
        Tiger jonny = new Tiger("Jonny");

        zwei.aufnehmen(leo);
        zwei.aufnehmen(jonny);

        Gehege<Katze> drei = new Gehege<>("Miau");
        Zoo<Gehege<?>> zoo = new Zoo<>();
        zoo.errichten(eins);
        zoo.abreissen(zwei);
        zoo.errichten(zwei);
        zoo.errichten(drei);

        Gehege<Fisch> blubblub = new Gehege<>("blub");
        Salzwasserfisch salty = new Salzwasserfisch("Glibber");
        Sueszwasserfisch sweet = new Sueszwasserfisch("Sugar");
        blubblub.aufnehmen(sweet);
        blubblub.aufnehmen(salty);

        Gehege<Fisch> water = new Gehege<>("Wasser");
        Salzwasserfisch saltyZwei = new Salzwasserfisch("Glibbery");
        Sueszwasserfisch sweetZwei = new Sueszwasserfisch("Sugary");
        Aquarium aqua = new Aquarium();
        aqua.errichten(blubblub);
        aqua.errichten(water);
    }
}
