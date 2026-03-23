package org.example.SoapClient;

import com.example.client.ICalculatrice;
import com.example.client.CalculatriceImpService;

public class Main {
	 public static void main(String[] args) {
		 System.out.println("Hello world!");
		 CalculatriceImpService service = new CalculatriceImpService() ;
		 ICalculatrice port = service.getCalculatriceImpPort();
		 
		 	double sum = port.add(50, 40);
	        double sub = port.subtract(50, 10);
	        double mul = port.multiply(5, 6);
	        double div = port.divide(20, 5);

	        System.out.println("Somme : " + sum);
	        System.out.println("Soustraction : " + sub);
	        System.out.println("Multiplication : " + mul);
	        System.out.println("Division : " + div);
	 }
}