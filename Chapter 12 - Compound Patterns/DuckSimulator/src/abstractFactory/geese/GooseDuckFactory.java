package abstractFactory.geese;

import adapter.GooseAdapter;
import ducks.Quackable;
import geese.Goose;

public class GooseDuckFactory extends AbstractGooseFactory {

    @Override
    public Quackable createGoose() {
        return new GooseAdapter(new Goose());
    }
    
}
