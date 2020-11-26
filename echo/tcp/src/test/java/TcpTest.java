import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TcpTest {

    private EchoClient client;

    @Before
    public void setup() throws IOException {
        String hostName = "127.0.0.1";
        int port = 9999;
        new EchoServer(port).start();
        client = new EchoClient(hostName, port);
    }

    @Test
    public void sendAndReceivePacketTest() throws IOException {
        String expectedResult = "hello server";
        String echo = client.send(expectedResult);
        assertEquals(expectedResult, echo);
        echo = client.send("server is working");
        assertNotEquals(expectedResult, echo);
    }

    @After
    public void tearDown() throws IOException {
        client.send(TcpUtils.TERMINAL_SEQUENCE);
        client.close();
    }

}
