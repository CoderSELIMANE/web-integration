package partie2exercice1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {

    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket();
        String message = "bonjour tout le monde";
        InetAddress address = InetAddress.getByName("localhost");
        byte[] buffer = message.getBytes();

        DatagramPacket packet = new DatagramPacket(
                buffer,
                buffer.length,
                address,
                7676
        );

        socket.send(packet);
        System.out.println("Message envoyé");

        socket.close();
    }
}