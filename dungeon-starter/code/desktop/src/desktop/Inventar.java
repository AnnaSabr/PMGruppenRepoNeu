package desktop;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventar {

    public static ArrayList<Items> inventar = new ArrayList<>();

    /**
     * Inventar auf Konsole anzeigen
     */
    public void ausgeben(){
        System.out.println(inventar.size()+" Items im Inventar.");
        for(int a = 0; a<inventar.size(); a++){
            String name="Item";
            if(inventar.get(a) instanceof Axe){
                name="Axt";
            } else if (inventar.get(a) instanceof Sword) {
                name="Schwert";
            } else if (inventar.get(a) instanceof SpeedPotion) {
                name="Schnelligkeitstrank";
            } else if (inventar.get(a) instanceof SpeedDecreasePotion) {
                name="Langsamkeitstrank";
            }
            System.out.println((a+1)+": " + name);
        }
    }

    /**
     * Inventar über Konsole steuern
     */
    public void anzeigen(){
        ausgeben();
        if(inventar.size()>0){
            entfernen();
            if(inventar.size()>0){
                ausgeben();
                ausruesten();
            }
        }
    }

    /**
     * Item aus Inventar entfernen
     */
    public void entfernen(){
        System.out.println("Welches Item soll entfernt werden?");
        Scanner scanner= new Scanner(System.in);
        String eingabe=scanner.nextLine();
        try{
            int zahl = Integer.parseInt(eingabe);
            zahl--;
            inventar.remove(zahl);
            zahl=zahl+1;
            System.out.println("Item " + zahl +" wurde entfernt.");
        } catch (Exception e) {
            System.out.println("Kein Item wurde entfernt.");
        }
    }

    /**
     * Item aus hand(Instanzvariable von MyHero) mit Item in Inventar tauschen
     */
    public void ausruesten(){
        System.out.println("Welches Item soll ausgeruestet werden?");
        Scanner scanner= new Scanner(System.in);
        String eingabe=scanner.nextLine();
        try{
            int zahl = Integer.parseInt(eingabe);
            zahl--;
            Items x;
            if(MyHero.hand!=null){
                x = MyHero.hand;
                MyHero.hand= inventar.get(zahl);
                inventar.add(x);
                inventar.remove(zahl);
            }
            else{
                MyHero.hand= inventar.get(zahl);
                inventar.remove(zahl);
            }
            zahl=zahl+1;
            System.out.println("Item "+ zahl + " wurde ausgeruestet.");
        } catch (Exception e) {
            System.out.println("Kein Item wurde ausgeruestet.");
        }
    }

    /**Item wird in das Inventar gelegt
     *
     * @param i
     * @return wurde das Item hinzugefügt
     */
    public static boolean hinzufuegen(Items i){
        if(inventar.size()<5){
            inventar.add(i);
            return true;
        }
        else{
            return false;
        }
    }

}
