import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class EchoServer {

    private static final String TERMINAL_SEQUENCE = "end";

    private static boolean isRunning = false;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);

        try (
                DatagramSocket serverDatagramSocket = new DatagramSocket(port)
        ) {
            isRunning = true;
            byte[] buffer = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            while (isRunning) {
                serverDatagramSocket.receive(datagramPacket);
                String received = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                if (received.equals(TERMINAL_SEQUENCE)) {
                    isRunning = false;
                }
                serverDatagramSocket.send(datagramPacket);
            }
        } catch (SocketException e) {
            System.out.println("Exception caught when trying to listen on port " + port);
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

