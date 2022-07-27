import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8844;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            String resp = "";
            while (!resp.startsWith("Bye")) {
                resp = in.readLine();
                System.out.println(resp);
                String ans = scanner.nextLine();
                out.println(ans);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
