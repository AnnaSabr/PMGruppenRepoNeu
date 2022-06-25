package desktop;

import basiselements.Entity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import graphic.Painter;
import level.elements.Level;
import tools.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Shop extends Entity {
    /**
     * A object that can be controlled by the <code>EntityController
     * </code>.
     *
     * @param painter Painter that draws this object
     * @param batch   Batch to draw on
     */
    public Shop(Painter painter, SpriteBatch batch) {
        super(painter, batch);
        texturePath="character/umgebung/gebaeude.png";
        int anzahl = (int) (Math.random()*5)+5;
        for(int a = 0; a<anzahl; a++){
            Items item;
            int zufall = (int) (Math.random()*13);
            if(zufall==0){
                item =new SpeedPotion(painter, batch);
            } else if (zufall==1) {
                item = new SpeedDecreasePotion(painter, batch);
            } else if (zufall==2) {
                item= new Sword(painter, batch);
            } else if (zufall==3) {
                item=new Axe(painter, batch);
            } else if (zufall==4) {
                zufall = (int) (Math.random()*2);
                if(zufall==0){
                    item = new Tasche<Weapon>(painter, batch);
                    item.nameTyp ="Waffen";
                }else {
                    item = new Tasche<Potion>(painter, batch);
                    item.nameTyp ="Tränke";
                }
            }else if(zufall==5){
                item=new Key(painter, batch);
            }else if(zufall==6){
                item=new Kraut(painter, batch);
            }else if(zufall==7){
                item=new Wein(painter, batch);
            }else if(zufall==8){
                item=new Kochtopf(painter, batch);
            }else if(zufall==9){
                item=new SpeedPotionRecipe(painter, batch);
            }else if(zufall==10){
                item=new Iron(painter, batch);
            }else if(zufall==11){
                item=new Hammer(painter,batch);
            }else{
                item=new SwordRecipe(painter,batch);
            }
            this.ware[a]=item;
        }

    }

    private Logger logger=Logger.getLogger(this.getClass().getName());


    Items[] ware=new Items[9];
    String texturePath;

    public void setLevel(Level level) {
        position = level.getRandomRoom().getRandomFloorTile().getCoordinate().toPoint();
    }

    /**
     * Interaktion mit dem Shop
     */
    public void handel(){
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(java.util.logging.Level.ALL);
        handler.setFormatter(new DialogFormatter());
        logger.addHandler(handler);
        boolean imGespreach = true;
        while(imGespreach){
            logger.info("Sag was:\n");
            DialogAntwortArt ausgewaehlt = auswertungEingabe(sprachEingabe());


            if (ausgewaehlt.equals(DialogAntwortArt.BEGRUESSUNG)) {
                logger.info("Hallo! Was willst du?\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.BELEIDIGUNG)) {
                logger.info("Benimm dich doch bitte etwas.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.VERABSCHIEDUNG)) {
                logger.info("Auf Wiedersehen.\n");
                imGespreach=false;
            }
            if (ausgewaehlt.equals(DialogAntwortArt.KOMPLIMENT)) {
                logger.info("Meinst du jetzt gebe ich dir einen Rabatt?\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.FLIRTEN)) {
                logger.info("Und kaufen willst du nichts?\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.BETTELN)) {
                logger.info("Was möchtest du denn haben?\n");
                this.kauf();
            }
            if (ausgewaehlt.equals(DialogAntwortArt.QUATSCH)) {
                logger.info("Was?\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.STUMM)) {
                logger.info("Was willst du denn jetzt?.\n");
            }
            if (ausgewaehlt.equals(DialogAntwortArt.RATEN)) {
                logger.info("Was bietest du mir an?\n");
                this.verkauf();
            }
        }
    }

    /**
     * auswählen was verkauft wird
     */
    public void verkauf(){
        String angebot = this.sprachEingabe();
        Pattern anbieten = Pattern.compile(".*(Axt|Hammer|Kraut|Schlüssel|Topf|Geschwindigkeitstrank|Langsamkeitstrank|Wein|Tasche|Schwertrezept|Trankrezept).*",Pattern.CASE_INSENSITIVE);
        if(anbieten.matcher(angebot).find()){
            Pattern p=Pattern.compile(".*(Axt)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof Axe){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Hammer)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof Hammer){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Kraut)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof Kraut){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Schlüssel)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof Key){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Topf)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof Kochtopf){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Geschwindigkeitstrank)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof SpeedPotionRecipe){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Langsamkeitstrank)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof SpeedDecreasePotion){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Trankrezept)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof SpeedPotionRecipe){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Schwert)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof Sword){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Schwertrezept)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof SwordRecipe){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Tasche)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof Tasche<?>){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            p=Pattern.compile(".*(Wein)");
            if(p.matcher(angebot).find()){
                for (int a =0; a<MyHero.itemInventar.getSize(); a++){
                    if(MyHero.itemInventar.inventar.get(a) instanceof Wein){
                        if(this.feilschen(false,MyHero.itemInventar.inventar.get(a))){
                            MyHero.itemInventar.inventar.remove(MyHero.itemInventar.inventar.get(a));
                        }
                        return;
                    }
                }
            }
            logger.info("Sowas hast du nicht.\n");
        }
    }

    /**
     * auswählen was gekauft werden soll
     */
    public void kauf(){
        //TODO umstrukturieren, Zahl der Zelle angeben, nicht unbedingt Namen nennen
        String angebot = this.sprachEingabe();
        Pattern anbieten = Pattern.compile(".*(Axt|Hammer|Kraut|Schlüssel|Topf|Geschwindigkeitstrank|Langsamkeitstrank|Wein|Tasche|Schwertrezept|Trankrezept|Schwert).*",Pattern.CASE_INSENSITIVE);
        if(anbieten.matcher(angebot).find()){
            Pattern p=Pattern.compile(".*(Axt).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof Axe){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Hammer).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof Hammer){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Kraut).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof Kraut){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Schlüssel).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof Key){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Topf).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof Kochtopf){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Geschwindigkeitstrank).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof SpeedPotionRecipe){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Langsamkeitstrank).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof SpeedDecreasePotion){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Trankrezept).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof SpeedPotionRecipe){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Schwert).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof Sword){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Schwertrezept).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof SwordRecipe){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Tasche).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof Tasche<?>){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
            p=Pattern.compile(".*(Wein).*");
            if(p.matcher(angebot).find()){
                for (int a =0; a<this.ware.length; a++){
                    if(this.ware[a] instanceof Wein){
                        if(this.feilschen(true,this.ware[a])){
                            this.ware[a]=null;
                        }
                        return;
                    }
                }
                logger.info("Das hab ich nicht\n");
                return;
            }
        }
        logger.info("Sowas hab ich nicht.\n");
    }

    /**
     * über Preise verhandeln
     * @param kaufen
     * @param items
     * @return
     */
    public boolean feilschen(boolean kaufen, Items items){
        int zufall;
        if(kaufen){
            zufall=(int) (Math.random()*5)+1;
        }
        else{
            zufall=(int) (Math.random()*10)+1;
        }
        //oder einfach annehmen TODO
        Pattern p = Pattern.compile("\\d+");
        boolean handeln = true;
        while(handeln){
            if(kaufen){
                logger.info("Das kostet " + items.preis + "\n");
            }
            String eingabe=this.sprachEingabe();
            if(kaufen){
                Pattern annehmen = Pattern.compile(".*(ja|ok).*");
                if(MyGame.geld>=items.preis && MyHero.itemInventar.hinzufuegen(items)){
                    MyGame.geld=MyGame.geld-items.preis;
                    return true;
                }if(MyGame.geld<items.preis)
                {
                    logger.info("Hast du etwa kein Geld?\n");
                    return false;
                }else{
                    logger.info("Hast du denn noch Platz im Inventar?\n");
                    return false;
                }
            }
            if(p.matcher(eingabe).find()){
                try{
                    int angebot = Integer.parseInt(eingabe);
                    if(kaufen){
                        if(angebot>items.preis-zufall){
                            logger.info("Okay.\n");
                            if(MyGame.geld<angebot){
                                logger.info("Hast du etwa kein Geld??\n");
                                return false;
                            }
                            else if(MyHero.itemInventar.hinzufuegen(items)){
                                MyGame.geld=MyGame.geld-angebot;
                                return true;
                            }else{
                                logger.info("Das kannst du ja garnicht tragen.\n");
                                return false;
                            }
                        }else{
                            logger.info("Nein\n");
                        }
                    }
                    if(!kaufen){
                        if(angebot<zufall){
                            logger.info("Okay\n");
                            MyHero.itemInventar.inventar.remove(items);
                            MyGame.geld=MyGame.geld+angebot;
                            return true;
                        }
                        else{
                            logger.info("Nein\n");
                        }
                    }
                }catch (Exception e){
                    logger.info("Wie viel Geld?\n");
                }
            }
            else{
                logger.info("Erklär mir nochmal was du willst.\n");
                handeln=false;
                return false;
            }
        }
        return false;
    }

    /**
     *
     * @return unsere Eingaben zum Dialog
     */
    public String sprachEingabe(){
        String eingabe="";
        Scanner sc= new Scanner(System.in);
        eingabe=sc.nextLine();
        return eingabe;
    }

    /**
     * Wertet die Eingabe des Spielers aus
     * @param eingabe das was der Spieler sagt
     * @return welche Art die Aussage des Spielers war
     */
    public DialogAntwortArt auswertungEingabe(String eingabe){
        List<DialogAntwortArt> gematched=new ArrayList<DialogAntwortArt>();

        Pattern begruessung=Pattern.compile(".*(hallo|guten *morgen|guten *tag|moin|hi|hey).*",Pattern.CASE_INSENSITIVE);
        Pattern beleidigung=Pattern.compile(".*du+.*(doof|dumm|langweilig|gemein|hässlich)|(doof|dumm|langweilig|gemein|hässlich).*du+.*",Pattern.CASE_INSENSITIVE);
        Pattern verabschiedung=Pattern.compile(".*(tschau|tschüss|bye|bis.*dann|auf.*wiedersehen).*",Pattern.CASE_INSENSITIVE);
        Pattern kompliment=Pattern.compile(".*du+.*(schön|schlau|groß|breit|hübsch)|(schön|schlau|groß|breit|hübsch).*du+.*",Pattern.CASE_INSENSITIVE);
        Pattern flirten=Pattern.compile(".*du+.*(heiß|sexy|hot)|(heiß|sexy|hot).*du+.*",Pattern.CASE_INSENSITIVE);
        Pattern kaufen=Pattern.compile(".*(haben|gib|will|kaufen).*",Pattern.CASE_INSENSITIVE);
        Pattern verkaufen=Pattern.compile(".*(gebe|verkaufe|biete an).*",Pattern.CASE_INSENSITIVE);

        if (eingabe.equals("")){
            return DialogAntwortArt.STUMM;
        }
        else if(begruessung.matcher(eingabe).find()){
            gematched.add(DialogAntwortArt.BEGRUESSUNG);
        }
        else if(beleidigung.matcher(eingabe).find()){
            gematched.add(DialogAntwortArt.BELEIDIGUNG);
        }
        else if(verabschiedung.matcher(eingabe).find()){
            gematched.add(DialogAntwortArt.VERABSCHIEDUNG);
        }
        else if(kompliment.matcher(eingabe).find()){
            gematched.add(DialogAntwortArt.KOMPLIMENT);
        }
        else if(flirten.matcher(eingabe).find()){
            gematched.add(DialogAntwortArt.FLIRTEN);
        }
        else if(kaufen.matcher(eingabe).find()){
            gematched.add(DialogAntwortArt.BETTELN);
        }
        else if(verkaufen.matcher(eingabe).find()){
            gematched.add(DialogAntwortArt.RATEN);
        }

        //TODO raten Dialogantwort
        if (gematched.size()!=0){
            if (gematched.contains(DialogAntwortArt.VERABSCHIEDUNG)){
                return DialogAntwortArt.VERABSCHIEDUNG;
            }
            if (gematched.contains(DialogAntwortArt.GEWONNEN)){
                return DialogAntwortArt.GEWONNEN;
            }
            if (gematched.contains(DialogAntwortArt.BELEIDIGUNG)){
                return DialogAntwortArt.BELEIDIGUNG;
            }
            if (gematched.contains(DialogAntwortArt.BETTELN)){
                return  DialogAntwortArt.BETTELN;
            }
            if (gematched.contains(DialogAntwortArt.FLIRTEN)){
                return DialogAntwortArt.FLIRTEN;
            }
            if (gematched.contains(DialogAntwortArt.KOMPLIMENT)){
                return DialogAntwortArt.KOMPLIMENT;
            }
            if (gematched.contains(DialogAntwortArt.BEGRUESSUNG)){
                return DialogAntwortArt.BEGRUESSUNG;
            }
            if (gematched.contains(DialogAntwortArt.STUMM)){
                return DialogAntwortArt.STUMM;
            }
        }
        return DialogAntwortArt.QUATSCH;
    }
    Point position;
    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public String getTexturePath() {
        return texturePath;
    }
}
