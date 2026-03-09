package partie2exercice1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;
import java.util.Scanner;

public class Sender2 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrer le port : ");
        int port = scanner.nextInt();

        String[] proverbes = {
                "Petit à petit l'oiseau fait son nid",
                "Qui vivra verra",
                "Après la pluie le beau temps",
                "L'habit ne fait pas le moine",
                "Mieux vaut tard que jamais"
        };

        Random random = new Random();

        String message = proverbes[random.nextInt(proverbes.length)];

        DatagramSocket socket = new DatagramSocket();

        InetAddress address = InetAddress.getByName("localhost");

        byte[] buffer = message.getBytes();

        DatagramPacket packet = new DatagramPacket(
                buffer,
                buffer.length,
                address,
                port
        );

        socket.send(packet);

        System.out.println("Proverbe envoyé : " + message);

        socket.close();
    }
}