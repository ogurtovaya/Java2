package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        new Server();

    }

    private ServerSocket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public Server(){
        try {
            socket = new ServerSocket(1515);
            scanner = new Scanner(System.in);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void start() throws IOException {
        System.out.println("Ожидание подключения сервера...");
        System.out.println("Сервер подключился...");
        Socket accepted = socket.accept();
        System.out.println("Клиент подключился...");


        in = new DataInputStream(accepted.getInputStream());
        out = new DataOutputStream(accepted.getOutputStream());

        new Thread(() ->{
            while (true) {
                try {String message = in.readUTF();
                    System.out.println("Клиент  " + message);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        while (true) {
            String out2 = scanner.nextLine();
            out.writeUTF(out2);
            out.writeUTF(scanner.nextLine());


        }
    }
}
