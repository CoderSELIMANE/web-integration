package Exercice2WebServer;

import java.io.*;
import java.net.Socket;

public class ConnexionsThread extends Thread{

    private Socket socket;
    public ConnexionsThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader br =new BufferedReader(new FileReader("C:/Users/PC/Desktop/index.html"));
            PrintWriter out =new PrintWriter(socket.getOutputStream(), true);

            out.println("HTTP/1.0 200 OK");
            out.println();
            String ligne;

            while ((ligne = br.readLine()) != null) {
                out.println(ligne);
            }

            br.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}