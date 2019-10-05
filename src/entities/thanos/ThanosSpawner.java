package entities.thanos;

import bases.FrameCounter;
import bases.GameObject;

public class ThanosSpawner extends GameObject {
    FrameCounter frameCounter;

    public ThanosSpawner(){
        frameCounter = new FrameCounter(200);
    }
    @Override
    public void run(){
        if (frameCounter.expired){
            Thanos newThanos = GameObject.recycle(Thanos.class);
            newThanos.position.set(303, 70);
            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}
