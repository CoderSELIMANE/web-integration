package exercice3ChatServer;

import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 9001);

            BufferedReader clavier =new BufferedReader(new InputStreamReader(System.in));

            BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out =new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Entrer votre pseudo : ");
            String pseudo = clavier.readLine();

            new Thread(() -> {
                try {
                    String msg;
                    
                    while ((msg = in.readLine()) != null) {

                        System.out.println(msg);
                    }
                } catch (Exception e) {
                }

            }).start();
            String message;
            while ((message = clavier.readLine()) != null) {

                out.println(pseudo + " : " + message);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
