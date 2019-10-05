package Scene;

import bases.GameObject;
import entities.Background;
import entities.HP;
import entities.gauntlet.Gauntlet;

import entities.gauntlet.GauntletSpawner;
import entities.player.captainamerica.CaptainAmerica;
import entities.player.ironman.IronMan;
import entities.thanos.Thanos;
import entities.thanos.ThanosSpawner;

public class GamePlayScene extends Scene{
    @Override
    public void init() {
        Background background = new Background();
        IronMan ironMan = GameObject.recycle(IronMan.class);

        Gauntlet gauntlet = GameObject.recycle(Gauntlet.class);
        GauntletSpawner gauntletSpawner = new GauntletSpawner();

        Thanos thanos = GameObject.recycle(Thanos.class);
        ThanosSpawner thanosSpawner = new ThanosSpawner();

        CaptainAmerica captainAmerica = GameObject.recycle(CaptainAmerica.class);


        HP hP = GameObject.recycle(HP.class);

    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
