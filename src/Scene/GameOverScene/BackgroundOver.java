package Scene.GameOverScene;

import Scene.SceneManager;
import Scene.welcomeScene.GameWelcomeScene;
import bases.GameObject;
import bases.KeyPressed;
import renderer.ImageRenderer;

public class BackgroundOver extends GameObject {
    public BackgroundOver(){
        this.renderer = new ImageRenderer("assets/images/scenes/game-over-background.jpg");
        this.anchor.set(0,0);
    }

    @Override
    public void run() {
        SceneManager.signNewScene(new GameOverScene());
        super.run();
        if (KeyPressed.getInstance().anyKeyPressed){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SceneManager.signNewScene(new GameWelcomeScene());
        }
    }
}