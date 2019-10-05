package entities.thanos;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import renderer.Animation;


public class Thanos extends GameObject {
    int spellNum = 4;
    int bullet_cnt = 0;
    public Thanos(){
        this.renderer = new Animation(20, SpriteUtils.loadImage("materials/Thanos.png"));
        this.position = new Vector2D(800, 800);
        this.boxCollider = new BoxCollider(this, 32,32);
    }
    @Override
    public void run(){
        this.deactiveIfNeeded();
        if (bullet_cnt >= 20){
            this.castSpell();
            bullet_cnt = 0;
        } else {
            bullet_cnt++;
        }
        this.position.addUp(0,3);
        super.run();
    }

    private void castSpell() {
        for (int i = 0; i < spellNum; i++){
            double tempAng = (360 / spellNum) * i;
            double radConvert = Math.toRadians(tempAng);
            ThanosBullet thanosBullet = GameObject.recycle(ThanosBullet.class);
            thanosBullet.newAngle = radConvert;
            thanosBullet.position.x = this.position.x + 8;
            thanosBullet.position.y = this.position.y + 32;
        }
    }


    public void deactiveIfNeeded(){
        if (this.position.y > 600 | this.position.y < 0 | this.position.x > 800 | this.position.x < 0){
            deActive();
        }
    }

    @Override
    public void deActive() {
        super.deActive();
        ThanosExplosion thanosExplosion = GameObject.recycle(ThanosExplosion.class);
        thanosExplosion.position.set(this.position);
    }
}
