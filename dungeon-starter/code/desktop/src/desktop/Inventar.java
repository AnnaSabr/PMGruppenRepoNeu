package desktop;

import java.util.ArrayList;

public class Inventar {

    //Items[] inventar = new Items[10];
    public static ArrayList<Items> inventar = new ArrayList();

    public void anzeigen(){
        System.out.println(inventar.size()+" Items im Inventar.");
        for(int a = 0; a<inventar.size(); a++){
            System.out.println(a+": " + );
        }
    }
}
