import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8090;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {


            out.println("Самый лучший клиент");

            String resp = in.readLine();
            System.out.println(resp);

            out.println("Мой порт Тортуга");

            resp = in.readLine();
            System.out.println(resp);

            resp = in.readLine();
            System.out.println(resp);

            out.println("Здесь рядом. На Карибах.");

            resp = in.readLine();
            System.out.println(resp);

            resp = in.readLine();
            System.out.println(resp);

            out.println("Конечно");
            resp = in.readLine();
            System.out.println(resp);

            resp = in.readLine();
            System.out.println(resp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
