import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class EchoServer extends Thread {

    private final DatagramSocket socket;
    private boolean isRunning = false;
    private final byte[] buf = new byte[256];

    public EchoServer(final int port) throws SocketException {
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            System.out.println("Exception caught when trying to listen on port " + port);
            throw e;
        }
    }

    @Override
    public void run() {
        isRunning = true;

        while (isRunning) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
                packet = new DatagramPacket(buf, buf.length, packet.getAddress(), packet.getPort());
                String received = new String(packet.getData(), 0, packet.getLength());

                if (received.equals(UdpUtils.TERMINAL_SEQUENCE)) {
                    isRunning = false;
                }
                socket.send(packet);
            } catch (IOException e) {
                System.err.println("I/O error occurred while sending or receiving data.");
                System.out.println(e.getMessage());
            }
        }
        socket.close();
    }

}