package desktop;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventar implements QuestObservable{

    public ArrayList<Items> inventar;

    ArrayList<QuestObserver> quests = new ArrayList<QuestObserver>();
    public Inventar(){
        inventar=new ArrayList<>();
    }


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
            } else if (inventar.get(a) instanceof Tasche<?>) {
                name="Tasche fuer "+ ((Tasche<?>) inventar.get(a)).nameTyp;
            }else if(inventar.get(a) instanceof Key){
                name="Schluessel";
            }else if(inventar.get(a) instanceof Wein){
                name="Wein";
            }else if(inventar.get(a) instanceof Kraut){
                name="Kraut";
            }else if(inventar.get(a) instanceof Kochtopf){
                name="Kochtopf";
            }else if(inventar.get(a) instanceof SpeedPotionRecipe){
                name="Rezept fuer Schnelligkeitstrank";
            }else if(inventar.get(a) instanceof Hammer){
                name="Hammer";
            }else if(inventar.get(a) instanceof Iron){
                name="Eisen";
            }else if(inventar.get(a) instanceof SwordRecipe){
                name="Rezept fuer Schwert";
            }
            System.out.println((a+1)+": " + name);
        }
    }

    /**
     * Item aus Inventar zurückgeben
     * @param a Index des Items
     * @return Item
     */
    public Items holen(int a){
        Items item = inventar.get(a);
        return item;
    }

    /**
     * Inventar über Konsole steuern
     */
    public void anzeigen(){
        ausgeben();
        if(inventar.size()>0){
            boolean tascheGefunden=false;
            for(int a =0; a<inventar.size();a++){
                if(inventar.get(a) instanceof Tasche<?>){
                    tascheGefunden=true;
                }
            }
            boolean rezeptGefunden=false;
            for(int a =0; a<inventar.size();a++){
                if(inventar.get(a) instanceof Recipe){
                    rezeptGefunden=true;
                }
            }
            if(rezeptGefunden){
                crafting();
            }
            if(tascheGefunden){
                System.out.println("Welche Tasche soll geoeffnet werden?");
                Scanner scanner= new Scanner(System.in);
                String eingabe=scanner.nextLine();
                try{
                    int zahl = Integer.parseInt(eingabe);
                    zahl=zahl-1;
                    ((Tasche<?>) inventar.get(zahl)).inhaltAusgeben();
                    zahl=zahl+1;
                } catch (Exception e) {
                    System.out.println("Kein Tasche wurde geoeffnet.");
                }
            }
        }
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
        System.out.println("Welches Item soll aus dem Inventar entfernt werden?");
        Scanner scanner= new Scanner(System.in);
        String eingabe=scanner.nextLine();
        try{
            int zahl = Integer.parseInt(eingabe);
            zahl--;
            itemEntfernen(zahl);
        } catch (Exception e) {
            System.out.println("Kein Item wurde entfernt.");
        }
    }

    /**
     * Item an einer Stelle entfernen
     * @param a Index des Items
     */
    public void itemEntfernen(int a){
            inventar.remove(a);
            a=a+1;
            System.out.println("Item " + a +" wurde entfernt.");
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
    public boolean hinzufuegen(Items i){
        for(int a=0;a<inventar.size();a++){
            if (inventar.get(a) instanceof Tasche<?>) {
                if (((Tasche<?>) inventar.get(a)).tascheInventar.size() < 3) {
                    if (i instanceof Weapon && inventar.get(a).nameTyp=="Waffen") {
                        Weapon weapon = (Weapon) i;
                        ((Tasche<Weapon>) inventar.get(a)).tascheInventar.add(weapon);
                        return true;
                    } else if (i instanceof Potion && inventar.get(a).nameTyp=="Tränke") {
                        Potion potion= (Potion) i;
                        ((Tasche<Potion>)  inventar.get(a)).tascheInventar.add(potion);
                        return true;
                    }
                }
            }
        }
        if(inventar.size()<5){
            inventar.add(i);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Rezept im Inventar wird verwendet
     */
    public void crafting(){
        System.out.println("Rezept auswaehlen");
        Scanner scanner= new Scanner(System.in);
        String eingabe=scanner.nextLine();
        try{
            int zahl = Integer.parseInt(eingabe);
            zahl--;
            if(inventar.get(zahl) instanceof Recipe){
                if (((Recipe) inventar.get(zahl)).useRecipe()){
                    System.out.println("Das Rezept wurde verwendet");
                }
            }
        }catch(Exception e){
            System.out.println("kein Rezept gefunden");
        }
    }

    /**
     * gibt die Anzahl der Items im Inventar aus
     *
     * @return
     */
    public int getSize(){
        return inventar.size();
    }

    @Override
    public void register(QuestObserver questObserver) {
        this.quests.add(questObserver);
    }

    @Override
    public void unregister(QuestObserver questObserver) {
        quests.remove(questObserver);
    }

    @Override
    public void notifyObservers() {
        for(QuestObserver q : quests){
            q.questUpdate();
        }
    }
    public void questErfuellen(QuestObserver questObserver){


    }
}
