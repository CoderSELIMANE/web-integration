package rmiFibonacci;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FibonacciImpl extends UnicastRemoteObject implements IFibonacci {

    protected FibonacciImpl() throws RemoteException {
        super();
    }

    public int fibonacci(int n) throws RemoteException {
        if (n <= 1)
            return n;
        return fibonacci(n -1) + fibonacci(n -2);
    }
}