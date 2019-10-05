package entities.gauntlet;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import renderer.Animation;


public class Gauntlet extends GameObject {
    public Gauntlet(){
        this.renderer = new Animation(20, SpriteUtils.loadImage("materials/Gauntlet.png"));
        this.position = new Vector2D(800, 800);
        this.boxCollider = new BoxCollider(this, 32,32);
    }
    @Override
    public void run(){
        this.deactiveIfNeeded();
        /**
         * consider using trigonometry to move Enemy
         */
        this.position.addUp(0,3);
        super.run();
    }



    public void deactiveIfNeeded(){
        if (this.position.y > 600 | this.position.y < 0 | this.position.x > 800 | this.position.x < 0){
            deActive();
        }
    }

    @Override
    public void deActive() {
        super.deActive();
        GauntletExplosion gauntletExplosion = GameObject.recycle(GauntletExplosion.class);
        gauntletExplosion.position.set(this.position);
    }
}
