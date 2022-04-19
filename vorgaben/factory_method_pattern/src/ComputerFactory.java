/**
*   Implementierung des Factory-Pattern.
 */
public class ComputerFactory {
    private ComputerFactory() {

    }

    private static String zweck1 = "stationaer";
    private static String zweck2 = "mobil";
    private static String zweck3 = "nicht daheim";
    private static String leistung1 = "leise schnurrend";
    private static String leistung2 = "viel Wumms";

    /**
    *   Diese Methode liefert abhängig von den Übergabeparameretn ein Oject der Klasse Computer zurueck.
    *   @param String s1, Dieser Uebergabeparameter gibt den Zweck des Computers an.
    *   @param String s2, Dieser Uebergabeparameter gibt die Leistung des Computers an.
    *   @return Computer computer
     */
    public static Computer buildComputer(String s1, String s2) {

        if(s1.compareTo(ComputerFactory.zweck1) == 0) {
            if(s2.compareTo(ComputerFactory.leistung1) == 0) {
                return new DesktopComputer(new Ram(16), new Hdd(256), new Cpu(8, 1.21f));
            }
            else if(s2.compareTo(ComputerFactory.leistung2) == 0) {
                return new DesktopComputer(new Ram(32), new Ssd(2000), new Cpu(16, 4.21f));
            }
            else {
                return null;
            }
        }
        else if(s1.compareTo(ComputerFactory.zweck2) == 0) {
            if(s2.compareTo(ComputerFactory.leistung1) == 0) {
                return new LaptopComputer(new Ram(8), new Hdd(256), new Cpu(4, 1.21f));
            }
            else if(s2.compareTo(ComputerFactory.leistung2) == 0) {
                return new LaptopComputer(new Ram(16), new Ssd(256), new Cpu(8, 2.41f));
            }
            else {
                return null;
            }
        }
        else if(s1.compareTo(ComputerFactory.zweck3) == 0) {
            if(s2.compareTo(ComputerFactory.leistung1) == 0) {
                return new CloudComputer(new Ram(24), new Hdd(1000), new Cpu(8, 2.21f));
            }
            else if(s2.compareTo(ComputerFactory.leistung2) == 0) {
                return new CloudComputer(new Ram(128), new Ssd(10000), new Cpu(42, 9.001f));
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

}
