package bundesliga.generic;

public class Spieler implements ISpieler {

    String name;

    public Spieler(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }
}
