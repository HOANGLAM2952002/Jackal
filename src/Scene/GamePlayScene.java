package Scene;

import bases.GameObject;
import entities.Background;
import entities.bomb.Bomb;

import entities.bomb.BombSpawner;
import entities.player.captainamerica.CaptainAmerica;
import entities.player.ironman.IronMan;

public class GamePlayScene extends Scene{
    @Override
    public void init() {
        Background background = new Background();
        IronMan ironMan = GameObject.recycle(IronMan.class);
        Bomb bomb = GameObject.recycle(Bomb.class);
        BombSpawner bombSpawner = new BombSpawner();
        CaptainAmerica captainAmerica = GameObject.recycle(CaptainAmerica.class);

    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
