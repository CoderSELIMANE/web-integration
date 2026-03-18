package rmiFibonacci;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFibonacci extends Remote {

    public int fibonacci(int n) throws RemoteException;

}