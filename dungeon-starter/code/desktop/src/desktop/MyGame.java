package desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import controller.ControllerLayer;
import controller.HUDController;
import controller.MainController;
import graphic.HUDPainter;
import level.LevelAPI;
import level.generator.LevelLoader.LevelLoader;
import level.generator.dungeong.graphg.NoSolutionException;
import tools.Point;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Erzeugt den Game Loop und verwaltet die Helden und Monster
 */
public class MyGame extends MainController {
    private MyHero hero;
    Items item;
    Chest chest;
    Quest quest;
    private Logger logger=Logger.getLogger(this.getClass().getName());
    private int levelCounter=0;
    ArrayList<Monster> monster;
    ArrayList<Monster> monsterEntfernen;
    ArrayList<Fallen> fallen;
    Point heroposition;
    ArrayList<Items> it;
    Npc npc;
    Pfeil pfeil;
    BossTank tank;
    private int time;
    boolean inventarVisible = false;
    InventarUI ui;
    private boolean amReden=false;
    static int geld=0;
    Kontostand k;
    Shop shop;
    ShopUI shopUI;


    /**
     * Starttet das Spiel bei Game over neu und reseted alle wichtigen Werte
     */
    public void neustart(){
        entityController.remove(shop);
        entityController.clear();
        hudController.clear();


        time=0;
        levelCounter=0;

        hero= new MyHero(50,5,0.1f, painter, batch);
        heroposition = hero.getPosition();

        item = new SpeedPotion(painter, batch);

        monster.clear();
        fallen.clear();
        monsterEntfernen.clear();
        it.clear();

        try {
            levelAPI.loadLevel();
        } catch (NoSolutionException e) {
            System.out.println(
                "Es konnte kein Level geladen werden, bitte den \"assets\" Ordner überprüfen.");
            Gdx.app.exit();
        }


        geld=0;
        k=new Kontostand(hudPainter,hudBatch);
        hudController.add(k);
        hudController.add(k.z1);

        shop=new Shop(painter,batch);
        shop.setLevel(levelAPI.getCurrentLevel());
        entityController.add(shop);
        camera.follow(hero);
        entityController.add(item);
        hudController.add(new Icon(hudPainter, hudBatch, new Point(0f,0f)));
    }

    @Override
    protected void setup() {
        time=0;
        levelAPI.setGenerator(new LevelLoader()); //ausklammern fuer prozedualen Levelgenerator
        hero = new MyHero(50,5,0.1f, painter, batch);
        heroposition = hero.getPosition();
        monster = new ArrayList<>();
        item = new SpeedPotion(painter, batch);
        fallen = new ArrayList<>();
        monsterEntfernen = new ArrayList<>();
        it= new ArrayList<>();
        // load the first level
        try {
            levelAPI.loadLevel();
        } catch (NoSolutionException e) {
            System.out.println(
                "Es konnte kein Level geladen werden, bitte den \"assets\" Ordner überprüfen.");
            Gdx.app.exit();
        }
        k=new Kontostand(hudPainter,hudBatch);
        hudController.add(k);
        hudController.add(k.z1);
        if(geld>9){
            hudController.add(k.z2);
        }
        if(geld>99){
            hudController.add(k.z3);
        }

        camera.follow(hero);
        entityController.add(item);
        hudController.add(new Icon(hudPainter, hudBatch, new Point(0f,0f)));
    }

    @Override
    protected void beginFrame() {
        heroposition = hero.getPosition();
        time++;
        double heroX = Math.round((heroposition.x * 100) / 100);
        double heroY = Math.round((heroposition.y * 100) / 100);
        dia();
        for (Fallen element : fallen) {
            double falleX = Math.round((element.getPosition().x * 100) / 100);
            double falleY = Math.round((element.getPosition().y * 100) / 100);
            if (heroX == falleX && heroY == falleY) {
                element.effekte(hero);

            }
            for (Monster ele : monster) {
                double monsterX = Math.round((ele.getPosition().x * 100) / 100);
                double monsterY = Math.round((ele.getPosition().y * 100) / 100);
                if (monsterX == falleX && monsterY == falleY) {
                    element.effekte(ele);
                }
                if (ele.isDead()){
                    monsterEntfernen.add(ele);
                }
            }
        }
        double shopX = Math.round((shop.getPosition().x * 100) / 100);
        double shopY = Math.round((shop.getPosition().y * 100) / 100);
        if(shopX == heroX && shopY == heroY && Gdx.input.isKeyJustPressed(Input.Keys.R)){
            shopUI=new ShopUI(hudPainter,hudBatch,this.shop);
            hudController.add(shopUI);
            hudController.add(shopUI.slot1);
            hudController.add(shopUI.slot2);
            hudController.add(shopUI.slot3);
            hudController.add(shopUI.slot4);
            hudController.add(shopUI.slot5);
            hudController.add(shopUI.slot6);
            hudController.add(shopUI.slot7);
            hudController.add(shopUI.slot8);
            hudController.add(shopUI.slot9);
            //this.shop.handel();
            /*hudController.remove(shopUI.slot9);
            hudController.remove(shopUI.slot8);
            hudController.remove(shopUI.slot7);
            hudController.remove(shopUI.slot6);
            hudController.remove(shopUI.slot5);
            hudController.remove(shopUI.slot4);
            hudController.remove(shopUI.slot3);
            hudController.remove(shopUI.slot2);
            hudController.remove(shopUI.slot1);
            hudController.remove(shopUI);*/
        }
        if(shopX == heroX && shopY == heroY && Gdx.input.isKeyJustPressed(Input.Keys.U)){
            this.shop.handel();
            hudController.remove(shopUI.slot9);
            hudController.remove(shopUI.slot8);
            hudController.remove(shopUI.slot7);
            hudController.remove(shopUI.slot6);
            hudController.remove(shopUI.slot5);
            hudController.remove(shopUI.slot4);
            hudController.remove(shopUI.slot3);
            hudController.remove(shopUI.slot2);
            hudController.remove(shopUI.slot1);
            hudController.remove(shopUI);

            hudController.remove(k);
            hudController.remove(k.z1);
            if(geld>9){
                hudController.remove(k.z2);
            }
            if(geld>99){
                hudController.remove(k.z3);
            }
            geld++;
            k=new Kontostand(hudPainter,hudBatch);
            hudController.add(k);
            hudController.add(k.z1);
            if(geld>9){
                hudController.add(k.z2);
            }
            if(geld>99){
                hudController.add(k.z3);
            }
        }
        for (Items item: it){
            double itX=Math.round((item.getPosition().x));
            double itY=Math.round((item.getPosition().y));
            if (itX == heroX && itY == heroY&&Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                if(item instanceof Geld){
                    item.setTaken(true);
                    entityController.remove(item);
                    hudController.remove(k);
                    hudController.remove(k.z1);
                    if(geld>9){
                        hudController.remove(k.z2);
                    }
                    if(geld>99){
                        hudController.remove(k.z3);
                    }
                    geld++;
                    k=new Kontostand(hudPainter,hudBatch);
                    hudController.add(k);
                    hudController.add(k.z1);
                    if(geld>9){
                        hudController.add(k.z2);
                    }
                    if(geld>99){
                        hudController.add(k.z3);
                    }
                }
                else if(MyHero.itemInventar.hinzufuegen(item)){
                    item.setTaken(true);
                    entityController.remove(item);
                }

            }
        }
        double itX=Math.round((chest.getPosition().x));
        double itY=Math.round((chest.getPosition().y));
        if (itX == heroX && itY == heroY&&Gdx.input.isKeyJustPressed(Input.Keys.L)) {
            if(chest.offen){
                chest.oeffnen();
            }
            if(MyHero.hand instanceof Key){
                chest.oeffnen();
                MyHero.hand=null;
            }
        }

        double itXquest=Math.round((quest.getPosition().x));
        double itYquest=Math.round((quest.getPosition().y));
        if(itXquest == heroX && itYquest == heroY && Gdx.input.isKeyJustPressed(Input.Keys.E)){
            quest.questVorschlagen();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.P)){
            if(MyHero.acceptedQuest.isEmpty()){
                System.out.println("Keine Quests angenommen");
            }else{
                for(int a =0; a < MyHero.acceptedQuest.size(); a++){
                    System.out.println(MyHero.acceptedQuest.get(a).questTask);
                    System.out.println(MyHero.acceptedQuest.get(a).questReward);
                }
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.I)){
            if(!inventarVisible){
                ui = new InventarUI(hudPainter,hudBatch);
                hudController.add(ui.slot1, new ControllerLayer(ControllerLayer.TOP_VALUE));
                hudController.add(ui.slot2, new ControllerLayer(ControllerLayer.TOP_VALUE));
                hudController.add(ui.slot3, new ControllerLayer(ControllerLayer.TOP_VALUE));
                hudController.add(ui.slot4, new ControllerLayer(ControllerLayer.TOP_VALUE));
                hudController.add(ui.slot5, new ControllerLayer(ControllerLayer.TOP_VALUE));
                hudController.add(ui.slotHand, new ControllerLayer(ControllerLayer.TOP_VALUE));

                hudController.add(ui, new ControllerLayer(ControllerLayer.DEFAULT_VALUE));
                this.inventarVisible=true;
                ui.setLevel(levelAPI.getCurrentLevel());
            }else{
                ui.invisible=true;
                hudController.remove(ui.slot1);
                hudController.remove(ui.slot2);
                hudController.remove(ui.slot3);
                hudController.remove(ui.slot4);
                hudController.remove(ui.slot5);
                hudController.remove(ui.slotHand);
                this.inventarVisible=false;
            }
        }
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            if(Gdx.input.getY()>6 && Gdx.input.getY()<45){
                if(Gdx.input.getX()>7 && Gdx.input.getX()<45){
                    if(ui.ausgewaehlt==ui.slot1 && MyHero.itemInventar.inventar.size()>=1){
                        if(MyHero.itemInventar.inventar.get(0) instanceof Potion){
                            ((Potion) MyHero.itemInventar.inventar.get(0)).usePotion();
                            MyHero.itemInventar.inventar.remove(0);
                        }
                    }else{
                        ui.ausgewaehlt=ui.slot1;
                    }
                }else if(Gdx.input.getX()>60 && Gdx.input.getX()<100){
                    if(ui.ausgewaehlt==ui.slot2 && MyHero.itemInventar.inventar.size()>=2){
                        if(MyHero.itemInventar.inventar.get(1) instanceof Potion){
                            ((Potion) MyHero.itemInventar.inventar.get(1)).usePotion();
                            MyHero.itemInventar.inventar.remove(1);
                        }
                    }else{
                        ui.ausgewaehlt=ui.slot2;
                    }
                }else if(Gdx.input.getX()>114 && Gdx.input.getX()<153){
                    if(ui.ausgewaehlt==ui.slot3 && MyHero.itemInventar.inventar.size()>=3){
                        if(MyHero.itemInventar.inventar.get(2) instanceof Potion){
                            ((Potion) MyHero.itemInventar.inventar.get(2)).usePotion();
                            MyHero.itemInventar.inventar.remove(2);
                        }
                    }else{
                        ui.ausgewaehlt=ui.slot3;
                    }
                }else if(Gdx.input.getX()>168 && Gdx.input.getX()<207){
                    if(ui.ausgewaehlt==ui.slot4 && MyHero.itemInventar.inventar.size()>=4){
                        if(MyHero.itemInventar.inventar.get(3) instanceof Potion){
                            ((Potion) MyHero.itemInventar.inventar.get(3)).usePotion();
                            MyHero.itemInventar.inventar.remove(3);
                        }
                    }else{
                        ui.ausgewaehlt=ui.slot4;
                    }
                }else if(Gdx.input.getX()>220 && Gdx.input.getX()<261){
                    if(ui.ausgewaehlt==ui.slot5 && MyHero.itemInventar.inventar.size()>=5){
                        if(MyHero.itemInventar.inventar.get(4) instanceof Potion){
                            ((Potion) MyHero.itemInventar.inventar.get(4)).usePotion();
                            MyHero.itemInventar.inventar.remove(4);
                        }
                    }else{
                        ui.ausgewaehlt=ui.slot5;
                    }
                }else if(Gdx.input.getX()>274 && Gdx.input.getX()<313){
                    System.out.println(ui.ausgewaehlt);
                    if(!this.auswaehlenTausch()){
                        if(MyHero.hand instanceof Potion){
                            ((Potion) MyHero.itemInventar.inventar.get(4)).usePotion();
                            MyHero.itemInventar.inventar.remove(4);
                        }
                    }
                }

            }
        }
        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
            if(Gdx.input.getY()>6 && Gdx.input.getY()<45){
                if(Gdx.input.getX()>7 && Gdx.input.getX()<45){
                    if(MyHero.itemInventar.inventar.size()>=1){
                        MyHero.itemInventar.inventar.remove(0);
                    }
                } else if(Gdx.input.getX()>60 && Gdx.input.getX()<100) {
                    if(MyHero.itemInventar.inventar.size()>=2){
                        MyHero.itemInventar.inventar.remove(1);
                    }
                }else if(Gdx.input.getX()>168 && Gdx.input.getX()<207){
                    if(MyHero.itemInventar.inventar.size()>=4){
                        MyHero.itemInventar.inventar.remove(3);
                    }
                }else if(Gdx.input.getX()>114 && Gdx.input.getX()<153){
                    if(MyHero.itemInventar.inventar.size()>=3){
                        MyHero.itemInventar.inventar.remove(2);
                    }
                }else if(Gdx.input.getX()>220 && Gdx.input.getX()<261){
                    if(MyHero.itemInventar.inventar.size()>=5){
                        MyHero.itemInventar.inventar.remove(4);
                    }
                }else if(Gdx.input.getX()>274 && Gdx.input.getX()<313){
                    MyHero.hand=null;
                }
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            System.out.println("coord");
            System.out.println(Gdx.input.getX());
            System.out.println(Gdx.input.getY());
        }

        if (pfeil.isKaputt()){
            MyHero.itemInventar.inventar.remove(pfeil);
            MyHero.itemInventar.hinzufuegen(pfeil=new Pfeil(hero,EProjektile.NORD,painter,batch));
            entityController.add(pfeil);
            pfeil.setLevel(levelAPI.getCurrentLevel());
        }

    }


    @Override
    protected void endFrame() {
        if (levelAPI.getCurrentLevel().isOnEndTile(hero)) {
            try {
                levelAPI.loadLevel();
            } catch (NoSolutionException e) {
                e.printStackTrace();
            }
        }
        lebenAbziehen();
        if (monsterEntfernen!=null){
            for (Monster mnst: monsterEntfernen){
                monster.remove(mnst);
            }
            monsterEntfernen= new ArrayList<>();
        }
        if (hero.isDead()){
            logger.info("GAME OVER DU NOOB");
            logger.info("Druecke + um das Spiel neu zu starten oder irgendwas anderes um es zu beenden.");
            Scanner sc = new Scanner(System.in);
            String eingabe=sc.next();
            if (eingabe.equals("+")){
                neustart();
            }
            else {
                Gdx.app.exit();
                System.out.println("beendet");
            }
        }
    }

    @Override
    public void onLevelLoad() {
        MyHero.itemInventar.inventar.remove(pfeil);
        heroposition = hero.getPosition();
        levelCounter++;
        entityController.remove(hero);
        entityController.remove(npc);
        entityController.remove(item);
        entityController.remove(chest);
        entityController.remove(quest);
        entityController.remove(shop);

        for (Items element : it) {
            entityController.remove(element);
        }

        for (Monster element : monster) {
            entityController.remove(element);
        }
        for (Fallen element : fallen) {
            entityController.remove(element);
        }

        fallenGenerieren();
        for(int i = 0;i<5;i++){
            itemPlatzieren();
        }

        truhePlatzieren();

        for (Fallen ele : fallen) {
            entityController.add(ele);
            ele.setLevel(levelAPI.getCurrentLevel());
        }

        questErstellen();
        shop=new Shop(painter,batch);
        shop.setLevel(levelAPI.getCurrentLevel());
        entityController.add(shop);

        hero.setLevel(levelAPI.getCurrentLevel());//bei text im hud nicht mehr in funktion
        npcGenerieren();
        npc.setLevel(levelAPI.getCurrentLevel());
        entityController.add(npc);
        pfeil = new Pfeil(hero,EProjektile.NORD,painter,batch);
        MyHero.itemInventar.hinzufuegen(pfeil);
        entityController.add(pfeil);
        pfeil.setLevel(levelAPI.getCurrentLevel());
        entityController.add(hero);
        monsterGenerieren();
        FigurenBewegung tanken=new BewegungTank(hero);
        if (levelCounter==1){
            tank = new BossTank(tanken,30,5,0.6f,painter,batch);
            monster.add(tank);
        }
        for (Monster element : monster) {
            entityController.add(element);
            element.setLevel(levelAPI.getCurrentLevel());
        }
    }

    /**
     * Erstellt die Level angepasste Anzahl Monster und deren Werte
     */
    public void monsterGenerieren() {
        FigurenBewegung kuschel=new WillKuscheLnMonster(hero);
        FigurenBewegung freiSchnauze= new RandomMonster();
        FigurenBewegung klassentreffen = new KlassentreffenMonster(hero);
        Random ran = new Random();
        monster = new ArrayList<>();
        int r = ran.nextInt(2 + levelCounter);
        for (int a = 0; a < r; a++) {
            monster.add(MonsterCreator.getMonster(kuschel,1 + levelCounter, 0.1f, 3 + levelCounter, EMonster.SKELET, painter, batch));
            monster.add(MonsterCreator.getMonster(freiSchnauze,1 + levelCounter, 0.1f, 3 + levelCounter, EMonster.NECROMANT, painter, batch));
        }
    }


    /**
     * Erstellt fuer das Level einen Npc nahc dem Zufallsprinzip
     */
    public void npcGenerieren(){
        FigurenBewegung stand=new NpcStand(hero);
        FigurenBewegung wandern = new NpcWandern(hero);
        Random ran = new Random();
        int r= ran.nextInt(2);
        if (r==1){
            this.npc=NpcCreator.getNpc(stand,100,100,0.1f,ENpcs.ELF,painter,batch);
        }
        else{
            this.npc=NpcCreator.getNpc(wandern,100,100,0.3f,ENpcs.LIZARD,painter,batch);
        }

    }

    /**
     * Truhe mit zwei oder drei Items im Level platzieren
     */
    public void truhePlatzieren(){

        chest=new Chest(painter, batch);
        int zufallAnzahl=(int) (Math.random()*2);
        zufallAnzahl=zufallAnzahl+2;
        Items item;
        for(int a=0; a<zufallAnzahl;a++){
            int zufall = (int) (Math.random()*12);
            if(zufall==0){
                item =new SpeedPotion(painter, batch);
            } else if (zufall==1) {
                item = new SpeedDecreasePotion(painter, batch);
            } else if (zufall==2) {
                item= new Sword(painter, batch);
            } else if (zufall==3) {
                item=new Axe(painter, batch);
            } else if(zufall==4){
                item=new Kraut(painter, batch);
            } else if(zufall==5){
                item=new Wein(painter, batch);
            } else if(zufall==6){
                item=new Kochtopf(painter, batch);
            } else if(zufall==7){
                item=new SpeedPotionRecipe(painter, batch);
            }else if(zufall==8){
                item=new Hammer(painter,batch);
            }else if(zufall==9){
                item=new SwordRecipe(painter,batch);
            }else if(zufall==10){
                item=new Iron(painter,batch);
            }
            else{
                item=new Key(painter, batch);
            }
            chest.schatz.hinzufuegen(item);
        }
        entityController.add(chest);
        chest.setLevel(levelAPI.getCurrentLevel());
    }

    /**
     * ausgewähltes Item mit Hand-Item tauschen
     */
    public boolean auswaehlenTausch(){
        if(ui.ausgewaehlt!=null){
            int a = 0;
            if(ui.ausgewaehlt.equals(ui.slot1)){
                a=0;
            } else if (ui.ausgewaehlt.equals(ui.slot2)) {
                a=1;
            } else if (ui.ausgewaehlt.equals(ui.slot3)) {
                a=2;
            } else if (ui.ausgewaehlt.equals(ui.slot4)) {
                a=3;
            } else if (ui.ausgewaehlt.equals(ui.slot5)) {
                a=4;
            }if(MyHero.itemInventar.inventar.size()>=a+1){
                Items i = MyHero.itemInventar.inventar.get(a);
                MyHero.itemInventar.inventar.remove(a);
                MyHero.itemInventar.inventar.add(MyHero.hand);
                MyHero.hand = i;
                ui.ausgewaehlt=null;
                return true;
            }
        }
        return false;
    }

    /**
     * erstellt ein zufälliges Item
     */
    public void itemPlatzieren(){
        int zufall = (int) (Math.random()*13);
        //int zufall = 3;
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
        }else if(zufall==12){
            item=new SwordRecipe(painter,batch);
        }
        Geld g = new Geld(painter,batch);
        entityController.add(g);
        entityController.add(item);
        g.setLevel(levelAPI.getCurrentLevel());
        it.add(g);
        item.setLevel(levelAPI.getCurrentLevel());
        it.add(item);
    }


    /**
     * Erstellt die Fallen fuer das Level
     */
    public void fallenGenerieren() {
        int i = 1;
        fallen = new ArrayList<>();
        if (levelCounter < 2) {
            i = i + levelCounter;
            for (int a = 0; a <= i; a++) {
                fallen.add(FallenCreator.getFallen(EFallen.SPIKES,  painter, batch));
            }
        } else {
            for (int b = 0; b <= 5; b++) {
                fallen.add(FallenCreator.getFallen(EFallen.HOLE,  painter, batch));
            }
        }
    }

    /**
     *  zufällige Quest erstellen
     */
    public void questErstellen() {
        int zufall = (int) (Math.random() * 2);
        if (zufall == 1) {
            quest = new CollectionQuest(painter, batch);
        } else {
            quest = new CraftingQuest(painter, batch);
        }
        entityController.add(quest);
        quest.setLevel(levelAPI.getCurrentLevel());
    }


     /**
     * bestimmt was passiert, wenn ein MOnster von einem Projektil getroffen wird
      * und den damage den MOnster am Helden machen
     */
    public void lebenAbziehen(){
        if (pfeil.getRichtung()!=EProjektile.LEER){
            for (Monster boese: monster){
                double distanz = Math.sqrt(Math.pow(pfeil.getPosition().x - boese.getPosition().x, 2.0) + Math.pow(pfeil.getPosition().y - boese.getPosition().y, 2.0));
                if(distanz<1){
                    boese.getroffen(pfeil.getRichtung());
                    boese.setLebenspunkte(2);
                    pfeil.schrott();
                }
            }
        }
        for (Monster ele: monster){
            int damage=0;
            double distanz = Math.sqrt(Math.pow(hero.getPosition().x - ele.getPosition().x, 2.0) + Math.pow(hero.getPosition().y - ele.getPosition().y, 2.0));
            damage=ele.angriff(distanz);
            if (distanz<3&&time%30==0){
                hero.setLebenspunkte(damage);
                if (ele instanceof BossTank){
                    logger.info("Boss damage: "+damage);
                }
            }
        }
    }



    /**
     * ruft die dialog Funktion auf
     */
    public void dia(){
        double distanz = Math.sqrt(Math.pow(hero.getPosition().x - npc.getPosition().x, 2.0) + Math.pow(hero.getPosition().y - npc.getPosition().y, 2.0));
        if (distanz<3&&Gdx.input.isKeyJustPressed(Input.Keys.E)){
            npc.dialog();
        }
    }

    public static void main(String[] args) {
        // start the game
        DesktopLauncher.run(new MyGame());
    }
}
