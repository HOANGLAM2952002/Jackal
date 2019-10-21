package entities.player.ironman;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.gauntlet.Gauntlet;

import entities.player.captainamerica.CaptainAmerica;
import entities.player.captainamerica.CaptainAmericaShoot;
import entities.thanos.Thanos;
import renderer.Animation;


public class IronManShoot extends GameObject{

    public IronManShoot(){
        this.velocity.set(0, -10);
        this.renderer = new Animation(20, SpriteUtils.loadImage("materials/IronShoot.png"));
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 32, 32);
    }

    public void run() {
        deactiveIfNeeded();

        Gauntlet gauntlet = GameObject.checkCollider(this, Gauntlet.class);
        if (gauntlet != null){
            System.out.println("dang va cham");
            gauntlet.deActive();
            this.deActive();
            pointIron += 10;
        }

        CaptainAmerica captainAmerica = GameObject.checkCollider(this, CaptainAmerica.class);
        if (captainAmerica != null){
            System.out.println("dang va cham");
            captainAmerica.deActive();
            this.deActive();
            remainCap--;
            pointIron += 20;
        }

        CaptainAmericaShoot captainAmericaShoot = GameObject.checkCollider(this, CaptainAmericaShoot.class);
        if (captainAmericaShoot != null){
            System.out.println("dang va cham");
            captainAmericaShoot.deActive();
            this.deActive();
        }

        Thanos thanos = GameObject.checkCollider(this,Thanos.class);
        if (thanos != null){
            System.out.println("dang va cham");
            this.deActive();
            thanos.deActive();
            pointIron += 30;
        }

        super.run();
    }

    public void deactiveIfNeeded(){
        if (this.position.x < 20){
            deActive();
        }
        if (this.position.y < 0){
            deActive();
        }
        if (this.position.y > 550){
            deActive();
        }
    }

}
