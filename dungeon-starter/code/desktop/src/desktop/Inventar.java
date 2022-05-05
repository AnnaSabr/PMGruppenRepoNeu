package desktop;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventar {

    public static ArrayList<Items> inventar = new ArrayList<>();

    /**
     * Inventar auf Konsole anzeigen
     */
    public void anzeigen(){
        System.out.println(inventar.size()+" Items im Inventar.");
        for(int a = 0; a<inventar.size(); a++){
            System.out.println((a+1)+": " + inventar.get(a).getClass().getName());
        }
        if(inventar.size()>0){
            entfernen();
            if(inventar.size()>0){
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
        String eingabe=scanner.next();
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
     * Item aus hand mit Item in Inventar tauschen
     */
    public void ausruesten(){
        System.out.println("Welches Item soll ausgeruestet werden?");
        Scanner scanner= new Scanner(System.in);
        String eingabe=scanner.next();
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
        } catch (NumberFormatException e) {
            System.out.println("Kein Item wurde ausgeruestet.");
        }
    }

}
