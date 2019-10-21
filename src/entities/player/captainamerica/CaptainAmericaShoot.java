package entities.player.captainamerica;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.gauntlet.Gauntlet;
import entities.player.ironman.IronMan;
import entities.player.ironman.IronManShoot;
import entities.thanos.Thanos;
import renderer.Animation;


public class CaptainAmericaShoot extends GameObject {
    public CaptainAmericaShoot(){
        this.velocity.set(0,-10);
        this.renderer = new Animation(20, SpriteUtils.loadImage("materials/CapShoot.png"));
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 32, 32);
    }

    public void run(){
        deActiveIfNeeded();


        Gauntlet gauntlet = GameObject.checkCollider(this, Gauntlet.class);
        if (gauntlet != null){
            System.out.println("dang va cham");
            gauntlet.deActive();
            this.deActive();
            pointCap += 10;
        }

        IronMan ironMan = GameObject.checkCollider(this, IronMan.class);
        if (ironMan != null){
            System.out.println("dang va cham");
            this.deActive();
            ironMan.deActive();
            pointCap += 20;
            remainIron--;
        }

        IronManShoot ironManShoot = GameObject.checkCollider(this, IronManShoot.class);
        if (ironManShoot != null){
            System.out.println("dang va cham");
            this.deActive();
            ironManShoot.deActive();
        }

        Thanos thanos = GameObject.checkCollider(this,Thanos.class);
        if (thanos != null){
            System.out.println("dang va cham");
            this.deActive();
            thanos.deActive();
            pointCap += 30;
        }

        super.run();
    }

    private void deActiveIfNeeded() {
        if (this.position.x > 580){
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
