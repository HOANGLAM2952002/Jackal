package Scene.GameOverScene;

import Scene.SceneManager;
import Scene.welcomeScene.GameWelcomeScene;
import bases.GameObject;
import bases.KeyPressed;
import renderer.ImageRenderer;

public class BackgroundOver extends GameObject {
    public BackgroundOver(){
        //this.renderer = new ImageRenderer("materials/background.png");
        if (GameObject.remainCap < 1){
            this.renderer = new ImageRenderer("materials/OverIron.png");
        }
        if (GameObject.remainIron < 1){
            this.renderer = new ImageRenderer("materials/OverCap.png");
        }
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
            remainCap = 5;
            remainIron = 5;
            pointCap = 0;
            pointIron = 0;
            CapUltimate = 5;
            IronUltimate = 5;
            CapNormal = 10;
            IronNormal = 10;
            SceneManager.signNewScene(new GameWelcomeScene());
        }
    }
}
