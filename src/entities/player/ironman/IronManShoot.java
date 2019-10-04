package entities.player.ironman;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.bomb.Bomb;

import entities.player.captainamerica.CaptainAmerica;
import renderer.Animation;


public class IronManShoot extends GameObject{

    public IronManShoot(){
        this.velocity.set(0, -5);
        this.renderer = new Animation(20, SpriteUtils.loadImage("materials/IronShoot.png"));
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 24, 24);
    }

    public void run() {
        deactiveIfNeeded();

        Bomb bomb = GameObject.checkCollider(this, Bomb.class);
        if (bomb != null){
            System.out.println("dang va cham");
            bomb.deActive();
            this.deActive();
        }

        CaptainAmerica captainAmerica = GameObject.checkCollider(this, CaptainAmerica.class);
        if (captainAmerica != null){
            System.out.println("dang va cham");
            captainAmerica.deActive();
            this.deActive();
        }

        super.run();
    }


    public void deactiveIfNeeded(){
        if (this.position.x < 20){
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
