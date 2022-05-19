package desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import controller.MainController;
import level.generator.LevelLoader.LevelLoader;
import level.generator.dungeong.graphg.NoSolutionException;
import tools.Point;

import java.util.ArrayList;
import java.util.Random;

/**
 * Erzeugt den Game Loop und verwaltet die Helden und Monster
 */
public class MyGame extends MainController {
    private MyHero hero;
    Items item;
    Chest chest;

    private com.badlogic.gdx.scenes.scene2d.ui.Label levelLabel;
    private int levelCounter=0;
    ArrayList<Monster> monster;
    ArrayList<Fallen> fallen;
    Point heroposition;
    ArrayList<Items> it;

    @Override
    protected void setup() {
        levelAPI.setGenerator(new LevelLoader()); //ausklammern fuer prozedualen Levelgenerator
        hero = new MyHero(50 + levelCounter,5,0.1f, painter, batch);
        heroposition = hero.getPosition();
        monster = new ArrayList<>();
        item = new SpeedPotion(painter, batch);
        fallen = new ArrayList<>();
        it= new ArrayList<>();
        // load the first level
        try {
            levelAPI.loadLevel();
        } catch (NoSolutionException e) {
            System.out.println(
                "Es konnte kein Level geladen werden, bitte den \"assets\" Ordner überprüfen.");
            Gdx.app.exit();
        }
        camera.follow(hero);
        entityController.add(item);
        hudController.add(new Icon(hudPainter, hudBatch, new Point(0f,0f)));
    }

    @Override
    protected void beginFrame() {
        heroposition = hero.getPosition();
        double heroX = Math.round((heroposition.x * 100) / 100);
        double heroY = Math.round((heroposition.y * 100) / 100);
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
            }
        }
        for (Items item: it){
            double itX=Math.round((item.getPosition().x));
            double itY=Math.round((item.getPosition().y));
            if (itX == heroX && itY == heroY&&Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                if(MyHero.itemInventar.hinzufuegen(item)){
                    item.setTaken(true);
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
    }

    @Override
    public void onLevelLoad() {
        heroposition = hero.getPosition();
        levelCounter++;
        entityController.remove(hero);
        entityController.remove(item);
        entityController.remove(chest);

        for (Monster element : monster) {
            entityController.remove(element);
        }
        for (Fallen element : fallen) {
            entityController.remove(element);
        }
        monsterGenerieren();
        fallenGenerieren();
        for(int i = 0;i<5;i++){
            itemPlatzieren();
        }

        truhePlatzieren();

        for (Fallen ele : fallen) {
            entityController.add(ele);
            ele.setLevel(levelAPI.getCurrentLevel());
        }
        for (Monster element : monster) {
            entityController.add(element);
            element.setLevel(levelAPI.getCurrentLevel());
        }
        hero.setLevel(levelAPI.getCurrentLevel());//bei text im hud nicht mehr in funktion
        entityController.add(hero);
    }

    /**
     * Erstellt die Level angepasste Anzahl Monster und deren Werte
     */
    public void monsterGenerieren() {
        Random ran = new Random();
        monster = new ArrayList<>();
        int r = ran.nextInt(2 + levelCounter);
        for (int a = 0; a < r; a++) {
            monster.add(MonsterCreator.getMonster(1 + levelCounter, 0.1f, 3 + levelCounter, EMonster.SKELET, painter, batch));
            monster.add(MonsterCreator.getMonster(1 + levelCounter, 0.1f, 3 + levelCounter, EMonster.NECROMANT, painter, batch));
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
            int zufall = (int) (Math.random()*5);
            if(zufall==0){
                item =new SpeedPotion(painter, batch);
            } else if (zufall==1) {
                item = new SpeedDecreasePotion(painter, batch);
            } else if (zufall==2) {
                item= new Sword(painter, batch);
            } else if (zufall==3) {
                item=new Axe(painter, batch);
            }else{
                item=new Key(painter, batch);
            }
            chest.schatz.hinzufuegen(item);
        }
        entityController.add(chest);
        chest.setLevel(levelAPI.getCurrentLevel());
    }


    /**
     * erstellt ein zufälliges Item
     */
    public void itemPlatzieren(){
        //int zufall = (int) (Math.random()*10);
        int zufall = 9;
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
        }
        entityController.add(item);
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

    public static void main(String[] args) {
        // start the game
        DesktopLauncher.run(new MyGame());
    }
}
