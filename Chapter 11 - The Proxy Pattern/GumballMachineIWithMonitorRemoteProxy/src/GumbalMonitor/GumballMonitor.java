package GumbalMonitor;

import java.rmi.*;
import GumballMachineRemote.GumballMachineRemote;

public class GumballMonitor {
    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + machine.getLocation());
            System.out.println("Current inventory: " + machine.getCount() + " gumballs");
            System.out.println("Current state: " + machine.getState() + "\n\n");
        } catch (RemoteException e) {
            System.err.println("GumballMonitor exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
