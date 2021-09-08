package statePatternApproach;

public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("No gumballs, even is the quarter is accepted, you will not get a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You didn't inserted a quarter, so no quarter to return");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("No gumballs dispensed");
    }

    @Override
    public void winner() {
        System.out.println("No gumballs, no winner");
    }
}
