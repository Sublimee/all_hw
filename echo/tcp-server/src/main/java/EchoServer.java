import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final String TERMINAL_SEQUENCE = "end";

    private static boolean isRunning = true;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);

        try (
                ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null && isRunning) {
                out.println(inputLine);
                if (inputLine.equals(TERMINAL_SEQUENCE)) {
                    isRunning = false;
                }
            }
        } catch (IOException e) {
            System.err.println("Exception caught when trying to listen on port "
                    + port + " or listening for a connection");
            System.err.println(e.getMessage());
        }
    }

}