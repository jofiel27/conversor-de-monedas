import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private final HttpClient cliente = HttpClient.newHttpClient();

    public double obtenerConversion(String url) {
        try {
            HttpRequest solicitud = HttpRequest.newBuilder(URI.create(url)).build();
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            JsonElement elemento = JsonParser.parseString(respuesta.body());
            JsonObject objeto = elemento.getAsJsonObject();

            return objeto.get("conversion_result").getAsDouble();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
