package entities.hp;

import bases.GameObject;
import renderer.ImageRenderer;

public class HP extends GameObject {
    public HP(){
        this.renderer = new ImageRenderer("materials/HeartLives.png");
        this.position.set(0,0);
    }

    @Override
    public void deActive() {
        super.deActive();
        HPExplosion hpExplosion = GameObject.recycle(HPExplosion.class);
        hpExplosion.position.set(this.position);
    }
}
