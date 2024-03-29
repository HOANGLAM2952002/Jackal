package entities.thanos;

import bases.GameObject;
import bases.SpriteUtils;
import renderer.Animation;

public class ThanosBulletExplosion extends GameObject {
    public ThanosBulletExplosion(){
        this.renderer = new Animation(5, true,
                SpriteUtils.loadImage("assets/images/enemies/explosion/0.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/1.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/2.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/3.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/4.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/5.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/6.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/7.png"));
    }

    public void run(){
        Animation animation = (Animation) this.renderer;
        if (animation.finished){
            this.deActive();
            animation.reset();
        }
    }
}
