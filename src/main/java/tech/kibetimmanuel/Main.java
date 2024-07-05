package tech.kibetimmanuel;

import tech.kibetimmanuel.todo.TodoClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello world!");
        TodoClient client = new TodoClient();
//        System.out.println(client.getAllTodos());
        System.out.println(client.getTodo(1));
    }
}