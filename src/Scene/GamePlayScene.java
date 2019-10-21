package Scene;

import bases.AudioUtils;
import bases.GameObject;
import entities.Background;
import entities.CapBox;
import entities.hp.HP;
import entities.IronBox;
import entities.gauntlet.Gauntlet;

import entities.gauntlet.GauntletSpawner;
import entities.hp.HPSpawner;
import entities.player.captainamerica.CaptainAmerica;
import entities.player.ironman.IronMan;
import entities.thanos.Thanos;
import entities.thanos.ThanosSpawner;

public class GamePlayScene extends Scene{
    @Override
    public void init() {
        Background background = new Background();
        IronBox ironBox = new IronBox();
        CapBox capBox = new CapBox();

        IronMan ironMan = GameObject.recycle(IronMan.class);

        Gauntlet gauntlet = GameObject.recycle(Gauntlet.class);
        GauntletSpawner gauntletSpawner = new GauntletSpawner();

        Thanos thanos = GameObject.recycle(Thanos.class);
        ThanosSpawner thanosSpawner = new ThanosSpawner();

        CaptainAmerica captainAmerica = GameObject.recycle(CaptainAmerica.class);

        //HP hp = GameObject.recycle(HP.class);
        //HPSpawner hpSpawner = new HPSpawner();


    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
