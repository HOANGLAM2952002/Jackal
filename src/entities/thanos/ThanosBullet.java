package entities.thanos;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.player.captainamerica.CaptainAmerica;
import entities.player.captainamerica.CaptainAmericaShoot;
import entities.player.ironman.IronMan;
import entities.player.ironman.IronManShoot;
import renderer.Animation;

public class ThanosBullet extends GameObject {
    double spellDistance = 5;
    double newAngle;

    public ThanosBullet(){
        this.renderer = new Animation(20, SpriteUtils.loadImage("materials/ThanosBullet.png"));
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 10, 10);
    }

    public void run() {
        this.deactiveIfNeeded();
        this.position.x -= spellDistance * Math.sin(newAngle);
        this.position.y += spellDistance * Math.cos(newAngle);

        IronMan ironMan = GameObject.checkCollider(this, IronMan.class);
        if (ironMan != null){
            this.deActive();
            if (remainIron > 0){
                ironMan.deActive();
            }
            if (pointIron >= 10){
                pointIron -= 10;
            } else {
                pointIron = 0;
            }
        }

        IronManShoot ironManShoot = GameObject.checkCollider(this, IronManShoot.class);
        if (ironManShoot != null){
            ironManShoot.deActive();
            this.deActiveExplode();
        }

        CaptainAmerica captainAmerica = GameObject.checkCollider(this, CaptainAmerica.class);
        if (captainAmerica != null){
            this.deActive();
            if (remainCap > 0){
                captainAmerica.deActive();
            }
            if (pointCap >= 10){
                pointCap -= 10;
            } else {
                pointCap = 0;
            }
        }

        CaptainAmericaShoot captainAmericaShoot = GameObject.checkCollider(this, CaptainAmericaShoot.class);
        if (captainAmericaShoot != null){
            captainAmericaShoot.deActive();
            this.deActiveExplode();
        }
    }

    private void deactiveIfNeeded() {
        if (this.position.y > 550 | this.position.y < 0 | this.position.x > 580 | this.position.x < 20){
            this.deActive();
        }
    }

    public void deActiveExplode() {
        super.deActive();
        ThanosBulletExplosion thanosBulletExplosion = GameObject.recycle(ThanosBulletExplosion.class);
        thanosBulletExplosion.position.set(this.position);
    }
}
