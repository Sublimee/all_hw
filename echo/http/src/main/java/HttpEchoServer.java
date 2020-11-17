import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpEchoServer extends Thread {

    private final HttpServer server;

    public HttpEchoServer(String hostName, int port) throws IOException {
        server = HttpServer.create(new InetSocketAddress(hostName, port), 0);
        server.createContext("/echo", new EchoHttpHandler());
    }

    @Override
    public void run() {
        server.start();
    }

    public void close() {
        server.stop(0);
    }

}