import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HttpEchoTest {

    HttpEchoServer httpEchoServer;

    @Before
    public void init() throws IOException {
        httpEchoServer = new HttpEchoServer("localhost", 8001);
        httpEchoServer.start();
    }

    @Test
    public void echoTest() throws IOException, InterruptedException {
        HttpEchoClient httpEchoClient = new HttpEchoClient("http://localhost:8001/echo");
        final String expected = "HELLO";
        final String actual = httpEchoClient.send(expected);
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        httpEchoServer.close();
    }

}
