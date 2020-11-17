import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UdpTest {

    private EchoClient client;

    @Before
    public void setup() throws SocketException, UnknownHostException {
        final String hostName = "127.0.0.1";
        final int port = 9999;
        new EchoServer(port).start();
        client = new EchoClient(hostName, port);
    }

    @Test
    public void whenCanSendAndReceivePacket_thenCorrect() throws IOException {
        String expected = "hello server";
        String echo = client.sendEcho(expected);
        assertEquals(expected, echo);
        echo = client.sendEcho("server is working");
        assertNotEquals(expected, echo);
    }

    @After
    public void tearDown() throws IOException {
        client.sendEcho(UdpUtils.TERMINAL_SEQUENCE);
        client.close();
    }

}