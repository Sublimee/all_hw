import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class EchoHttpHandler implements HttpHandler {

    public static final int OK_RESPONSE_CODE = 200;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        try (OutputStream outputStream = httpExchange.getResponseBody();
             InputStreamReader is = new InputStreamReader(httpExchange.getRequestBody(), StandardCharsets.UTF_8)) {
            BufferedReader br = new BufferedReader(is);
            String responseBody = br.lines().collect(Collectors.joining("\n"));
            httpExchange.sendResponseHeaders(OK_RESPONSE_CODE, responseBody.length());
            outputStream.write(responseBody.getBytes());
            outputStream.flush();
        }
    }

}