package desktop;

import com.badlogic.gdx.Gdx;
import controller.MainController;
import level.generator.LevelLoader.LevelLoader;
import level.generator.dungeong.graphg.NoSolutionException;
import tools.Point;
import com.badlogic.gdx.graphics.Color;

public class MyGame extends MainController {
    private MyHero hero;
    private com.badlogic.gdx.scenes.scene2d.ui.Label levelLabel;
    private int levelCounter=0;

    @Override
    protected void setup() {
        levelAPI.setGenerator(new LevelLoader()); //ausklammern fuer prozedualen Levelgenerator
        hero = new MyHero(painter, batch);
        // load the first level
        try {
            levelAPI.loadLevel();
        } catch (NoSolutionException e) {
            System.out.println(
                    "Es konnte kein Level geladen werden, bitte den \"assets\" Ordner überprüfen.");
            Gdx.app.exit();
        }
        camera.follow(hero);
        entityController.add(hero);
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
        levelCounter++;
        hero.setLevel(levelAPI.getCurrentLevel()); //bei text im hud nicht mehr in funktion
        /*if (levelCounter==1){
            levelLabel=hudController.drawText("Level"+levelCounter,"PATH/TO/FONT.ttf",Color.RED,30,50,50,30,30);
        }
        else{
            levelLabel.setText("Level "+levelCounter);
        }*/
    }

    public static void main(String[] args) {
        // start the game
        DesktopLauncher.run(new MyGame());
    }
}
