package HomeWork7;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner = new Scanner(System.in);

    public Server() {

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("the server is running");
            socket = serverSocket.accept();
            System.out.println("client connected");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread t0 = new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF(scanner.next());
                    } catch (IOException e) {
                        System.out.println("Lost connection");
                        break;
                    }
                }
            });
            t0.start();

            while (true) {
                System.out.println(in.readUTF());
            }


        }

        catch (IOException e) {
            System.out.println("Lost connection");
        }

    }
}

