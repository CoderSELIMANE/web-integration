package Exercice2WebServer;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(8001);
            System.out.println("Serveur Web démarré sur le port 8001...");

            while (true) {
                Socket client = server.accept();
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                String corps = "<HTML><TITLE>Mon serveur</TITLE>" +
                				"Cette page a ete envoyee par mon <B>Serveur</B>" +
                				"</HTML>";

                out.println("HTTP/1.0 200 OK");
                out.println();
                out.println(corps);

                client.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
