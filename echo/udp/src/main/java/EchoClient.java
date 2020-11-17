import java.io.IOException;
import java.net.*;

public class EchoClient {

    private final DatagramSocket socket;
    private final InetAddress address;
    private final int port;

    public EchoClient(String hostName, int port) throws SocketException, UnknownHostException {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName(hostName);
        } catch (SocketException e) {
            System.out.println("Socket could not be opened.");
            throw e;
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            throw e;
        }
        this.port = port;
    }

    public String sendEcho(String msg) throws IOException {
        byte[] buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        try {
            socket.send(packet);
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
        } catch (IOException e) {
            System.err.println("I/O error occurred while sending or receiving data.");
            throw e;
        }
        return new String(packet.getData(), 0, packet.getLength());
    }

    public void close() {
        socket.close();
    }

}