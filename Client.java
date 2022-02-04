package HomeWork7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private static Scanner scanner = new Scanner(System.in);

    public  Client() {

        try {
            socket = new Socket("localHost", 8080);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread t0 = new Thread(() -> {
                while (true) {
                    try {
                        System.out.println(in.readUTF());
                    } catch (IOException e) {
                        System.out.println("Lost connection");
                        break;
                    }
                }
            });
            t0.start();

            while (true) {
                out.writeUTF(scanner.next());
            }

        } catch (IOException e) {
            System.out.println("Lost connection");
        }

    }
}


