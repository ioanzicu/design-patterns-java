import abstractFactory.ducks.AbstractDuckFactory;
import abstractFactory.ducks.CountingDuckFactory;
import abstractFactory.geese.AbstractGooseFactory;
import abstractFactory.geese.GooseDuckFactory;
import composite.Flock;
import decorator.QuackCounter;
import ducks.Quackable;
import observer.Quackologist;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        AbstractGooseFactory gooseFactory = new GooseDuckFactory();

        simulator.simulate(duckFactory, gooseFactory);
    }

    void simulate(AbstractDuckFactory duckFactory, AbstractGooseFactory gooseFactory) {
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        // Quackable gooseDuck = gooseFactory.createGoose();
        
        System.out.println("\nDuck Simlator: With Goose Adapter + Abstract Factory + Composite Flocks + Observer");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);

        Flock flockOfMallards = new Flock();
        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();
        
        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        Flock flockOfRedheadDucks = new Flock();
        Quackable redheadDuckOne = duckFactory.createRedheadDuck();
        Quackable redheadDuckTwo = duckFactory.createRedheadDuck();
        Quackable redheadDuckThree = duckFactory.createRedheadDuck();
        
        flockOfRedheadDucks.add(redheadDuckOne);
        flockOfRedheadDucks.add(redheadDuckTwo);
        flockOfRedheadDucks.add(redheadDuckThree);
        
        Flock flockOfRubberDuck = new Flock();
        Quackable rubberDuckOne = duckFactory.createRubberDuck();
        Quackable rubberDuckTwo = duckFactory.createRubberDuck();
        flockOfRubberDuck.add(rubberDuckOne);
        flockOfRubberDuck.add(rubberDuckTwo);
        flockOfRedheadDucks.add(flockOfRubberDuck);

        flockOfMallards.add(flockOfRedheadDucks);

        flockOfDucks.add(flockOfMallards);


        System.out.println("\nDuck Simulator: With Observer");
        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);
        
        simulate(flockOfDucks);

        // System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        // simulate(flockOfMallards);

        System.out.println("\nThe ducks quarked: " + 
                            QuackCounter.getQuacks() + 
                            " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
