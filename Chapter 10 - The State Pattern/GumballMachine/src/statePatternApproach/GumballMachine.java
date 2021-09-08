package statePatternApproach;


public class GumballMachine {

    //         /--------------\  <-------------------
    //        |  No Quarter    | <-----              \
    //         \--------------/        \              \
    //         |             A         |               |
    //  insert |             | eject   |               |
    //         V             |         |               |
    //         /--------------\        |               |
    //        |  Has Quarter   |       |               |
    //         \--------------/        |               |
    //                |                | gumballs > 0  |
    //                | turns crank    |               |
    //                V                |               | 
    //         /--------------\        |               |
    //        |  Gumball Sold  |       |               | refill
    //         \--------------/        |               |
    //                |                |               |
    //                | dispense      /                |
    //                |\_____________/                 |
    //                |                                | 
    //   gumballs = 0 |                                |
    //                |                                |
    //                V                               /
    //         /---------------\                     /
    //        | Out of Gumballs | ------------------/
    //         \---------------/         

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0){
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        if (state == hasQuarterState) {
            state.turnCrank();
            state.dispense();
        } else {
            System.out.println("... But you didn't inserted a quarter");
        }
    }
    
    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }
    
    void refill(int count) {
        System.out.println("Refilling the gumball machine");
        this.count = count;
        state = noQuarterState;
    }
    
    void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    @Override
    public String toString() {
        String message = "\nMega Gumball, Inc. Corp'\n";
        message += "Java-powered Virtual Gumball Model #333\n";
        message += "Inventory count: " + this.count + "\n";
        if (count == 0) {
            message += "Machine is sold out :( \n";
        } else {
            message += "Machine is waiting for quarter :) \n";
        }
        return message;
    }
}