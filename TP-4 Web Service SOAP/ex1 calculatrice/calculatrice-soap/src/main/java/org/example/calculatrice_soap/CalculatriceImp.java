package org.example.calculatrice_soap;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.calculatrice_soap.ICalculatrice")
public class CalculatriceImp implements ICalculatrice {

    @Override
    public double add(double x, double y) {
        System.out.println("Addition : " + x + " + " + y);
        return x + y;
    }
    @Override
    public double multiply(double x, double y) {
        System.out.println("Multiplication : " + x + " * " + y);
        return x * y;
    }
    @Override
    public double subtract(double x, double y) {
        System.out.println("Soustraction : " + x + " - " + y);
        return x - y;
    }
    @Override
    public double divide(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division par zéro !");
        }
        return x / y;
    }
}
