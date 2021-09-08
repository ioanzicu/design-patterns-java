package GumballMachineRemote;

import java.rmi.*;

import GumballMachine.State;

public interface GumballMachineRemote extends Remote {
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}