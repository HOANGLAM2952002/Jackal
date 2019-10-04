package entities.player.captainamerica;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.bomb.Bomb;
import entities.player.ironman.IronMan;
import renderer.Animation;


public class CaptainAmericaShoot extends GameObject {
    public CaptainAmericaShoot(){
        this.velocity.set(0,-5);
        this.renderer = new Animation(20, SpriteUtils.loadImage("materials/CapShoot.png"));
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 32, 32);
    }

    public void run(){
        deActiveIfNeeded();

        Bomb bomb = GameObject.checkCollider(this, Bomb.class);
        if (bomb != null){
            System.out.println("dang va cham");
            bomb.deActive();
            this.deActive();
        }

        IronMan ironMan = GameObject.checkCollider(this, IronMan.class);
        if (ironMan != null){
            System.out.println("dang va cham");
            this.deActive();
            ironMan.deActive();
        }

        super.run();
    }

    private void deActiveIfNeeded() {
        if (this.position.x > 580){
            deActive();
        }
        if (this.position.y < 220){
            deActive();
        }
        if (this.position.y > 550){
            deActive();
        }
    }
}
