import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import GumbalMonitor.GumballMonitor;
import GumballMachineRemote.GumballMachineRemote;

public class GumballMonitorTestDrive {
    
    public static void main(String[] args) {
        String[] location = {
            "rmi://santafe.mightygumball.com/gumballmachine",
            "rmi://boulder.mightygumball.com/gumballmachine",
            "rmi://seattle.mightygumball.com/gumballmachine"};
        
        GumballMonitor[] monitor = new GumballMonitor[location.length];
        
        for (int i=0; i < location.length; i++) {
            try {
                // Get reference to the Regestry
                Registry registry = LocateRegistry.getRegistry(null);

                // Take the reference to the stub from Registry | Stub is Proxy Object that points to the Real Service
                GumballMachineRemote machine = (GumballMachineRemote) registry.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
                System.out.println("\n\n");
            } catch (Exception e) {
                System.err.println("GumballMonitorTestDrive exception: " + e.toString());
                e.printStackTrace();      
            }
        }

        // Run the report method on the remote service 'stubs' via network
        // The stup | proxy object will send the method name and run it on Real Service
        for (int i=0; i < monitor.length; i++) {
            monitor[i].report();
        }
    } 
}
