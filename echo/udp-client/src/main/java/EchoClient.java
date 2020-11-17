import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoClient {

    private static final String TERMINAL_SEQUENCE = "end";

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int port = Integer.parseInt(args[1]);

        try (DatagramSocket socket = new DatagramSocket();
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            InetAddress address = InetAddress.getByName(hostName);

            String input;
            do {
                input = stdIn.readLine();
                DatagramPacket packet = new DatagramPacket(input.getBytes(), input.length(), address, port);
                socket.send(packet);
                socket.receive(packet);
                String received = new String(
                        packet.getData(), 0, packet.getLength());
                System.out.println("echo: " + received);
            }
            while (!TERMINAL_SEQUENCE.equals(input));
            System.out.println("Bye!");
        } catch (SocketException e) {
            System.out.println("Exception caught when trying to listen on port " + port);
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}