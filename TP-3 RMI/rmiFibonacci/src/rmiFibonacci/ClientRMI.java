package rmiFibonacci;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientRMI {

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1098);

            IFibonacci fib = (IFibonacci) registry.lookup("FIBO");

            Scanner sc = new Scanner(System.in);

            System.out.print("Entrer un nombre : ");
            int n = sc.nextInt();

            int result = fib.fibonacci(n);

            System.out.println("Fibonacci de " + n + " = " + result);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}