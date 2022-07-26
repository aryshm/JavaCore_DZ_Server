import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HostMain {

    public static void main(String[] args) {
        System.out.println("Started");
        int port = 8844;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("New connection accepted");
                out.println("What is your name?");
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d. How old are you?", name, clientSocket.getPort()));
                final int age = Integer.parseInt(in.readLine());
                if (age < 18) {
                    out.println(String.format("Welcome to the kids area %s. Where are you from?" , name));
                } else {
                    out.println(String.format("Welcome to the adult zone %s. Where are you from?" , name));
                }
                final String country = in.readLine();
                out.println(String.format("What is the native language in %s?" , country));
                final String language = in.readLine();
                out.println(String.format("Bye. Enjoy you time, our operator will continue conversation " +
                        "soon on %s." , language));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
