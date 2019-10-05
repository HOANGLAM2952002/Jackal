package entities;

import bases.GameObject;
import bases.SpriteUtils;
import renderer.Animation;

public class HP extends GameObject {
    public HP(float x, float y){
        this.renderer = new Animation(20, SpriteUtils.loadImage("materials/HeartLives.png"));
        this.position.x = x;
        this.position.y = y;
    }

    public void run(){

    }
}
