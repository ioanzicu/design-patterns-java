import java.util.Random;

import interfaces.Duck;
import interfaces.Turkey;

public class DuckAdapter implements Turkey {
    Duck duck;
    Random rand;
    
    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        System.out.println("But..., today I will fly 5 times less, I am tired :|");
        if (rand.nextInt(5) == 0) {
            duck.fly();
        }
    }
    
}
