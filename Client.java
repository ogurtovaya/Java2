package Lesson6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        new Client();
    }

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Scanner scanner;

    public Client() {
        try {
            this.socket = new Socket("localhost", 1515);
            this.scanner = new Scanner(System.in);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void start() throws IOException {

        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());

        new Thread(() ->{
            while (true){
            try {
                String message = in.readUTF();
                System.out.println("Сервер  " + message);

                } catch (IOException e) {
                    e.printStackTrace();
            }

            }
        }).start();

        while (true) {
            String out2 = scanner.nextLine();
            out.writeUTF(out2);



        }
    }
}
