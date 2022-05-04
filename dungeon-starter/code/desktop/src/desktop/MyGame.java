package desktop;

import com.badlogic.gdx.Gdx;
import controller.MainController;
import level.LevelAPI;
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
    Items sp;
    private com.badlogic.gdx.scenes.scene2d.ui.Label levelLabel;
    private int levelCounter=0;
    ArrayList<Monster> monster;

    @Override
    protected void setup() {
        levelAPI.setGenerator(new LevelLoader()); //ausklammern fuer prozedualen Levelgenerator
        hero = new MyHero(painter, batch);
        monster= new ArrayList<>();
        sp = new SpeedPotion(painter,batch);
        // load the first level
        try {
            levelAPI.loadLevel();
        } catch (NoSolutionException e) {
            System.out.println(
                    "Es konnte kein Level geladen werden, bitte den \"assets\" Ordner überprüfen.");
            Gdx.app.exit();
        }
        camera.follow(hero);
        entityController.add(sp);
        hudController.add(new Icon(hudPainter, hudBatch, new Point(0f,0f)));
    }

    @Override
    protected void beginFrame() {}

    @Override
    protected void endFrame() {
        if (levelAPI.getCurrentLevel().isOnEndTile(hero)){
            try{
                levelAPI.loadLevel();
            }
            catch (NoSolutionException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onLevelLoad() {
        for(Monster element: monster){
            entityController.remove(element);
        }
        entityController.add(hero);
        levelCounter++;
        monsterGenerieren();
        hero.setLevel(levelAPI.getCurrentLevel());//bei text im hud nicht mehr in funktion
        for (Monster element: monster){
            entityController.add(element);
            element.setLevel(levelAPI.getCurrentLevel());
        }
        sp.setLevel(levelAPI.getCurrentLevel());
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
    public void monsterGenerieren(){
        Random ran= new Random();
        monster= new ArrayList<>();
        int r=ran.nextInt(2+levelCounter);
        for (int a=0; a<r; a++){
            monster.add(MonsterCreator.getMonster(1+levelCounter,0.1f,3+levelCounter,EMonster.SKELET,painter, batch));
            monster.add(MonsterCreator.getMonster(1+levelCounter,0.1f,3+levelCounter,EMonster.NECROMANT,painter, batch));
        }
    }

    public static void main(String[] args) {
        // start the game
        DesktopLauncher.run(new MyGame());
    }
}
