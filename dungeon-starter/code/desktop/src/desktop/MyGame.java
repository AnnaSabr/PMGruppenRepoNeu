package desktop;

import com.badlogic.gdx.Gdx;
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
    SpeedPotion sp;
    private com.badlogic.gdx.scenes.scene2d.ui.Label levelLabel;
    private int levelCounter = 0;
    ArrayList<Monster> monster;
    ArrayList<Fallen> fallen;
    Point heroposition;

    @Override
    protected void setup() {
        levelAPI.setGenerator(new LevelLoader()); //ausklammern fuer prozedualen Levelgenerator
        hero = new MyHero(50 + levelCounter,5,0.1f, painter, batch);
        heroposition = hero.getPosition();
        monster = new ArrayList<>();
        sp = new SpeedPotion(painter, batch);
        fallen = new ArrayList<>();
        // load the first level
        try {
            levelAPI.loadLevel();
        } catch (NoSolutionException e) {
            System.out.println(
                "Es konnte kein Level geladen werden, bitte den \"assets\" Ordner überprüfen.");
            Gdx.app.exit();
        }
        camera.follow(hero);
        hudController.add(new Icon(hudPainter, hudBatch, new Point(0f, 0f)));
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
        for (Monster element : monster) {
            entityController.remove(element);
        }
        for (Fallen element : fallen) {
            entityController.remove(element);
        }
        monsterGenerieren();
        fallenGenerieren();
        for (Fallen element : fallen) {
            entityController.add(element);
            element.setLevel(levelAPI.getCurrentLevel());
        }
        for (Monster element : monster) {
            entityController.add(element);
            element.setLevel(levelAPI.getCurrentLevel());
        }
        hero.setLevel(levelAPI.getCurrentLevel());//bei text im hud nicht mehr in funktion
        sp.setLevel(levelAPI.getCurrentLevel());
        entityController.add(sp);
        entityController.add(hero);
        //bei text im hud nicht mehr in funktion
        /*if (levelCounter==1){
            levelLabel=hudController.drawText("Level"+levelCounter,"PATH/TO/FONT.ttf",Color.RED,30,50,50,30,30);
        }
        else{
            levelLabel.setText("Level "+levelCounter);
        }*/
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
