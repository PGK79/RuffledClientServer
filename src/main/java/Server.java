import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Сервер запущен");
        int port = 8090;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.printf("Установлено новое соединение. Port: %d%n", clientSocket.getPort());

                    String client = "Клиент: ";
                    String server = "Сервер: ";

                    final String name = in.readLine();

                   out.println(String.format("%sПривет %s, твой Port %d", server, name, clientSocket.getPort()));

                   String fromClient = in.readLine();
                   out.println(String.format("%s %s", client,fromClient));
                   out.println(String.format("%sЭто где такой ?", server));

                    fromClient = in.readLine();
                   out.println(String.format("%s %s", client,fromClient));
                   out.println(String.format("%sВ окно можно увидеть ?", server));

                    fromClient = in.readLine();
                    out.println(String.format("%s %s", client, fromClient));

                    if(fromClient.equals("Конечно")){
                        out.println(String.format("%sУже смотрю", server));
                    }else {
                        out.println(String.format("%sНе очень и хотелось", server));
                    }
                }
            }
        }
    }
}

