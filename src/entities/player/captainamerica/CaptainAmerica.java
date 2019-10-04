package entities.player.captainamerica;

import bases.*;
import renderer.Animation;


public class CaptainAmerica extends GameObject{
    long cnt = 0;
    long cnt1 = 0;

    public CaptainAmerica(){
        this.renderer = new Animation(10, SpriteUtils.loadImage("materials/CaptainAmerica.png"));
        this.position = new Vector2D(20, 380);
        this.cnt = 0;
        this.cnt1 = 0;
        this.boxCollider = new BoxCollider(this,32,32);
    }

    public void run(){
        float vx = 0, vy = 0;
        if (KeyPressed.getInstance().WPressed){
            vy = -5;
        }
        if (KeyPressed.getInstance().SPressed){
            vy = 5;
        }
//        if (KeyPressed.getInstance().DPressed){
//            vx = 10;
//        }
//        if (KeyPressed.getInstance().APressed){
//            vx = -10;
//        }

        if (KeyPressed.getInstance().CaptainshootPresed && cnt >= 20){
            this.castSpells();
            cnt = 0;
        } else {
            cnt++;
        }

        if (KeyPressed.getInstance().CaptainshootOnePressed && cnt1 >= 20){
            this.castOne();
            cnt1 = 0;
        } else {
            cnt1++;
        }

        this.position.x = Utils.clamp(this.position.x, 20,70);
        this.position.y = Utils.clamp(this.position.y, 220, 540);

        this.velocity.set(vx,vy);
        super.run();
    }

    private void castOne() {
        CaptainAmericaShoot captainAmericaShoot = GameObject.recycle(CaptainAmericaShoot.class);
        captainAmericaShoot.position.set(this.position.x, this.position.y);
        captainAmericaShoot.velocity.setAngle(Math.toRadians(0));
    }

    private void castSpells() {
        int numberB = 3;
        double startAngle = -120;
        double endAngle = -60;
        double step = (startAngle - endAngle) / (numberB - 1);
        for (int i = 0; i < numberB; i++){
            CaptainAmericaShoot newSpell = GameObject.recycle(CaptainAmericaShoot.class);
            newSpell.position.set(this.position.x, this.position.y);
            newSpell.velocity.setAngle(Math.toRadians(startAngle + step*i + 150));
        }
    }

    @Override
    public void deActive() {
        super.deActive();
        CaptainAmericaExplosion captainAmericaExplosion = new CaptainAmericaExplosion();
        captainAmericaExplosion.position.set(this.position);
    }
}
