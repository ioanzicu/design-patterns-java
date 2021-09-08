package RemoteMethodInvocation;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

    public Server() throws RemoteException { }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says, `Hey`";
    }
    
    public static void main(String[] args) {
        try {
            Server server = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);
            
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.out.println("Server ready");
        } catch (Exception e) { 
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
