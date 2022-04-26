package bundesliga.generic;

public class Generic1Test {

    public static void main(String args[]){

        FussballSpieler fb = new FussballSpieler("Peter");
        BasketballSpieler bs = new BasketballSpieler("Stefan");

        IMannschaft<FussballSpieler> mannschaft1 = new IMannschaft<FussballSpieler>() {
            @Override
            public boolean aufnehmen(FussballSpieler spieler) {
                return false;
            }

            @Override
            public boolean rauswerfen(FussballSpieler spieler) {
                return false;
            }
        };
        mannschaft1.aufnehmen(fb);
        System.out.println(bs.getName());

    }
}
