package com.fbp.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public class HttpLambdaClient {

    public String makePostRequest(String url, String jsonBody) throws JsonProcessingException{
        String status="";
        try (HttpClient client = HttpClient.newHttpClient()){
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
            HttpResponse<String> response=client
                .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + response.body());
            status=response.body();

        } catch (Exception e) {
        }
        return status;
    }
    
}
