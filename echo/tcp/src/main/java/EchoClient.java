import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

    private final Socket socket;
    private final PrintWriter out;
    private final BufferedReader in;

    public EchoClient(final String hostName, final int port) throws IOException {
        try {
            this.socket = new Socket(hostName, port);
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            throw e;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName + ":" + port);
            throw e;
        }
    }

    public String send(final String msg) throws IOException {
        try {
            out.println(msg);
            return in.readLine();
        } catch (IOException e) {
            System.err.println("I/O error with " + socket.getLocalAddress());
            throw e;
        }
    }

    public void close() throws IOException {
        socket.close();
    }

}
