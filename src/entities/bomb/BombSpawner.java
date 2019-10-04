package entities.bomb;

import bases.FrameCounter;
import bases.GameObject;

public class BombSpawner extends GameObject {
    FrameCounter frameCounter;

    public BombSpawner(){
        frameCounter = new FrameCounter(150);
    }
    @Override
    public void run(){
        if (frameCounter.expired){
            Bomb newBomb = GameObject.recycle(Bomb.class);
            newBomb.position.set(303, 0);
            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}
