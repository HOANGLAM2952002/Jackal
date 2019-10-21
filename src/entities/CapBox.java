package entities;

import bases.GameObject;
import renderer.ImageRenderer;

public class CapBox extends GameObject {
    public CapBox(){
        this.anchor.set(0,0);
        this.position.set(0,0);
        this.renderer = new ImageRenderer("materials/CapBox.png");
    }
}
