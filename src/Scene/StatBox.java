package Scene;

import entities.CapBox;
import entities.IronBox;

public class StatBox extends Scene{

    @Override
    public void init() {
        IronBox ironBox = new IronBox();
        CapBox capBox = new CapBox();
    }

    @Override
    public void clear() {
    }
}
