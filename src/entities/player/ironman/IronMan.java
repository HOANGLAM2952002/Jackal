package entities.player.ironman;
import Scene.GameOverScene.GameOverScene;
import Scene.SceneManager;
import bases.*;

import renderer.Animation;


public class IronMan extends GameObject {
    long cnt = 0;
    long cnt1 = 0;

    public IronMan(){
        this.renderer = new Animation(10, SpriteUtils.loadImage("materials/IronMan.png"));
        this.position = new Vector2D(580, 300);
        this.cnt = 0;
        this.cnt1 = 0;
        this.boxCollider = new BoxCollider(this, 32, 32);
    }
    /**
     * input keyPressed from GameCanvass
     * @param keyPressed (no need)
     */
    public void run() {

        float vx = 0, vy = 0;
        if (KeyPressed.getInstance().upPressed){
            vy = -5;
        }
        if (KeyPressed.getInstance().downPressed){
            vy = 5;
        }
//        if (KeyPressed.getInstance().rightPressed){
//            vx = 10;
//        }
//        if (KeyPressed.getInstance().leftPressed){
//            vx = -10;
//        }

        if (KeyPressed.getInstance().IronshootPresed && cnt >= 20 && IronUltimate >= 0){
            this.castSpells();
            cnt = 0;
            IronUltimate--;
        } else {
            cnt++;
        }

        if (KeyPressed.getInstance().IronshootOnePressed && cnt1 >= 20){
            this.castOne();
            cnt1 = 0;
        } else {
            cnt1++;
        }

        this.position.x = Utils.clamp(this.position.x, 530, 580);
        this.position.y = Utils.clamp(this.position.y, 20, 540);
        this.velocity.set(vx, vy);


        super.run();
    }

    private void castOne() {
        IronManShoot newOneSpell = GameObject.recycle(IronManShoot.class);
        newOneSpell.position.set(this.position.x, this.position.y);
        newOneSpell.velocity.setAngle(Math.toRadians(180));
    }

    /**
     * create a new spell
     * set original x,y the same with player
     * add into array list playerSpells
     */
    private void castSpells() {
        int numberB = 5;
        double startAngle = -120;
        double endAngle = -60;
        double step = (endAngle - startAngle) / (numberB - 1);
        for (int i = 0; i < numberB; i++){
            IronManShoot newSpell = GameObject.recycle(IronManShoot.class);
            newSpell.position.set(this.position.x, this.position.y);
            newSpell.velocity.setAngle(Math.toRadians(startAngle + step*i - 90));
        }
    }

    @Override
    public void deActive() {
        super.deActive();
        IronManExplosion ironManExplosion = new IronManExplosion();
        ironManExplosion.position.set(this.position);
        if (GameObject.remainIron > 0){
            IronMan ironMan = new IronMan();
            ironMan.position.set(580, 300);
        } else {
            SceneManager.signNewScene(new GameOverScene());
        }
    }
}

