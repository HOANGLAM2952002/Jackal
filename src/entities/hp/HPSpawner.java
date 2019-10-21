package entities.hp;

import bases.FrameCounter;
import bases.GameObject;

public class HPSpawner extends GameObject {
    FrameCounter frameCounter;
    public HPSpawner(){
        frameCounter = new FrameCounter(500);
    }

    @Override
    public void run() {
        int x,y;
        if (frameCounter.expired){
            HP hp1 = GameObject.recycle(HP.class);
            hp1.position.set(203,70);
            HP hp2 = GameObject.recycle(HP.class);
            hp2.position.set(403,70);
            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}

