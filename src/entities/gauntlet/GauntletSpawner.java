package entities.gauntlet;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class GauntletSpawner extends GameObject {
    FrameCounter frameCounter;


    public GauntletSpawner(){
        frameCounter = new FrameCounter(200);
    }
    @Override
    public void run(){
        if (frameCounter.expired){
            Gauntlet newGauntlet5 = GameObject.recycle(Gauntlet.class);
            newGauntlet5.position.set(370, 70);
            Gauntlet newGauntlet6 = GameObject.recycle(Gauntlet.class);
            newGauntlet6.position.set(230, 70);
            Gauntlet newGauntlet7 = GameObject.recycle(Gauntlet.class);
            newGauntlet7.position.set(300, 0);
            Gauntlet newGauntlet8 = GameObject.recycle(Gauntlet.class);
            newGauntlet8.position.set(300, 140);

            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}
