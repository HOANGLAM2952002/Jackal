package entities;

import bases.GameObject;
import renderer.ImageRenderer;

public class IronBox extends GameObject {
    public IronBox(){
        this.anchor.set(0,0);
        this.position.set(470,0);
        this.renderer = new ImageRenderer("materials/IronBox.png");
    }
}
