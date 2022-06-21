package desktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import graphic.Painter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Oberklasse der Npc
 *
 * enthaelt alle allgemein gueltigen Funktionen
 */
public abstract class  Npc extends Figuren{

    private Logger logger=Logger.getLogger(this.getClass().getName());
    private String[] zitate;
    private FigurenBewegung bewegung;

    public Npc(FigurenBewegung bewegung,int lebenspunkte, int staerke, float geschwindigkeit, Painter painter, SpriteBatch batch){
        super(lebenspunkte,staerke,geschwindigkeit,painter,batch);
        this.bewegung=bewegung;
        zitate=new String[10];
        zitate[0]="Appelschorle";
        zitate[1]="Nur Fleisch macht Fleisch!";
        zitate[2]="Skinny Bitch!";
        zitate[3]="The secret is: There is no secret.";
        zitate[4]="I dont eat for taste, I eat for function.";
        zitate[5]="I stuck with the basics of training.";
        zitate[6]="Ligth weigth baby!";
        zitate[7]="Everybody wants to be a powerbuilder, but dont nobody wants to lift no heavy ass weights.";
        zitate[8]="Stop whining!";
        zitate[9]="Failure is not an Option!";

    }

    public String[] getZitate() {
        return zitate;
    }

    /**
     * ruft die individuelle Bewegung des Npcs auf
     */
    public void bewegen(){
        bewegung.bewegen(this);
    }

    public abstract void dialog();

    public String sprachEingabe(){
        String eingabe="";
        Scanner sc= new Scanner(System.in);
        eingabe=sc.nextLine();
        return eingabe;
    }

    public DialogAntwortArt auswertungEingabe(String eingabe){
        List<DialogAntwortArt> gematched=new ArrayList<DialogAntwortArt>();

        Pattern begruessung=Pattern.compile(".*(hallo|guten *morgen|guten *tag|moin|hi|hey).*",Pattern.CASE_INSENSITIVE);
        Pattern beleidigung=Pattern.compile(".*du+.*(doof|dumm|langweilig|gemein|hässlich)|(doof|dumm|langweilig|gemein|hässlich).*du+.*",Pattern.CASE_INSENSITIVE);
        Pattern verabschiedung=Pattern.compile(".*(tschau|tschüss|bye|bis.*dann|auf.*wiedersehen).*",Pattern.CASE_INSENSITIVE);
        Pattern kompliment=Pattern.compile(".*du+.*(schön|schlau|groß|breit|hübsch)|(schön|schlau|groß|breit|hübsch).*du+.*",Pattern.CASE_INSENSITIVE);
        Pattern flirten=Pattern.compile(".*du+.*(heiß|sexy|hot)|(heiß|sexy|hot).*du+.*",Pattern.CASE_INSENSITIVE);
        Pattern betteln=Pattern.compile(".*(item|haben|gib|will).*",Pattern.CASE_INSENSITIVE);

        Pattern raten=Pattern.compile("testo",Pattern.CASE_INSENSITIVE);
        Pattern gewonnen=Pattern.compile("bodybuilding",Pattern.CASE_INSENSITIVE);

        if (eingabe.equals("")){
            return DialogAntwortArt.STUMM;
        }
        else if (raten.matcher(eingabe).find()){
            return DialogAntwortArt.RATEN;
        }
        else if(gewonnen.matcher(eingabe).find()){
            gematched.add(DialogAntwortArt.GEWONNEN);
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
        else if(betteln.matcher(eingabe).find()){
            gematched.add(DialogAntwortArt.BETTELN);
        }

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
}
