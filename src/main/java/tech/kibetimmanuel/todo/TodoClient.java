package tech.kibetimmanuel.todo;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class TodoClient {
    private final HttpClient client;
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/todos";
    private final ObjectMapper objectMapper;
    HttpRequest.Builder builder = HttpRequest.newBuilder();

    public TodoClient() {
        this.objectMapper = new ObjectMapper();
        client = HttpClient.newHttpClient();
    }

    public List<Todo> getAllTodos() throws IOException, InterruptedException {
        HttpRequest request = builder.uri(URI.create(BASE_URL))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), new TypeReference<>() {
        });
    }

    public Todo getTodo(int id) throws IOException, InterruptedException {
        HttpRequest request = builder
                .uri(URI.create(BASE_URL + '/' + id))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), new TypeReference<>() {});
    }
}
