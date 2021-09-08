import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import GumballMachine.GumballMachine;
import GumballMachineRemote.GumballMachineRemote;

public class GumballMachineTestDrive {
    public static void main(String[] args) throws Exception {
        int count = 0;

        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try {
            count = Integer.parseInt(args[1]);
            GumballMachine gumballMachine = new GumballMachine(args[0], count);

            // Instantiate a stub for GumballMachine Service
            GumballMachineRemote stub = (GumballMachineRemote) UnicastRemoteObject.exportObject(gumballMachine, 0);
          
            // Get Registry reference with default port of 1099
            Registry registry = LocateRegistry.getRegistry();
            // Register the stub in the Registry
            registry.bind("rmi://" + args[0] + "/gumballmachine", stub);

            System.out.println("GumballMachineTestDrive Ready");
        
            System.out.println(gumballMachine);

            gumballMachine.insertQuarter();
            gumballMachine.ejectQuarter();
            gumballMachine.turnCrank();
            System.out.println(gumballMachine);
            
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            System.out.println(gumballMachine);

            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            System.out.println(gumballMachine);
        
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            System.out.println(gumballMachine);

            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            System.out.println(gumballMachine);

            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            System.out.println(gumballMachine);

            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            System.out.println(gumballMachine);
        } catch (Exception e) {
            System.err.println("GumballMachineTestDrive exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
