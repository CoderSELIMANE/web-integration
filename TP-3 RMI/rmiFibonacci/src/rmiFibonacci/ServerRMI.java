package rmiFibonacci;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {

    public static void main(String[] args) {

        try {

            FibonacciImpl fib = new FibonacciImpl();

            Registry registry = LocateRegistry.createRegistry(1098);

            registry.rebind("FIBO", fib);

            System.out.println("Serveur RMI Fibonacci démarré");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}