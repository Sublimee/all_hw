import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer extends Thread {

    private boolean isRunning = false;

    private final ServerSocket serverSocket;

    public EchoServer(final int port) throws IOException {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + port);
            throw e;
        }
    }

    @Override
    public void run() {
        isRunning = true;

        try (
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null && isRunning) {
                if (inputLine.equals(TcpUtils.TERMINAL_SEQUENCE)) {
                    isRunning = false;
                }
                out.println(inputLine);
            }
        } catch (Exception e) {
            System.err.println("Exception caught when listening for a connection on port " + serverSocket.getLocalPort());
            System.err.println(e.getMessage());
        }
    }

}