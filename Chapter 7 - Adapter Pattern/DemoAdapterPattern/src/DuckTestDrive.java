import interfaces.Duck;
import interfaces.Turkey;

public class DuckTestDrive {
    public static void main(String[] args) throws Exception {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(turkey); 
        Turkey duckAdapter = new DuckAdapter(duck);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck (testDuck) says...");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdaper (testDuck) says...");
        testDuck(turkeyAdapter);

        System.out.println("\n\n\nThe Turkey (testTurkey) says...");
        testTurkey(turkey);

        System.out.println("\nThe DuckAdaper (testTurkey) says...");
        testTurkey(duckAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

    static void testTurkey(Turkey turkey) {
        turkey.gobble();
        turkey.fly();
    }
}
