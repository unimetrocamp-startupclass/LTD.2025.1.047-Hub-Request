package com.reqhub.reqhub.test;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class TesteRequisicoes {
    public static void main(String[] args) throws Exception {
        // Cadastro
        String cadastroJson = "{\"nome\": \"Oliveira2\", \"email\": \"oliveira2@gmail.com\", \"senha\": \"123\", \"setor\": {\"id\": 1}}";
        enviarRequisicao("http://localhost:5001/auths/cadastrar", cadastroJson);

        // Login
        String loginJson = "{\"email\": \"oliveira2@gmail.com\", \"senha\": \"123\"}";
        enviarRequisicao("http://localhost:5001/auths/login", loginJson);
    }

    private static void enviarRequisicao(String urlString, String jsonInput) throws Exception {
        URI uri = new URI(urlString);
        HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int code = conn.getResponseCode();
        System.out.println("Resposta do servidor (" + urlString + "): " + code);
        String response;
        if (code >= 200 && code < 300) {
            java.util.Scanner scanner = new java.util.Scanner(conn.getInputStream()).useDelimiter("\\A");
            response = scanner.hasNext() ? scanner.next() : "";
            scanner.close();
        } else {
            java.util.Scanner scanner = new java.util.Scanner(conn.getErrorStream()).useDelimiter("\\A");
            response = scanner.hasNext() ? scanner.next() : "";
            scanner.close();
        }
        System.out.println("Conteúdo da resposta: " + response);
        conn.disconnect();
    }
}