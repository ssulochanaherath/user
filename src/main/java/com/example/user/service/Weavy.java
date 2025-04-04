package com.example.user.service;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Map;

@Service
public class Weavy {
    @Value("${weavy.api.url}")
    private String apiUrl;

    @Value("${weavy.token}")
    private String bearerToken;

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public String createUser(Map<String, String> userData) {
        return sendRequest("/users", "POST", gson.toJson(userData));
    }

    public String updateUser(String userId, Map<String, String> userData) {
        return sendRequest("/users/" + userId, "PUT", gson.toJson(userData));
    }

    public String deleteUser(String userId) {
        return sendRequest("/users/" + userId, "DELETE", null);
    }

    private String sendRequest(String path, String method, String requestBodyJson) {
        RequestBody body = null;
        if (requestBodyJson != null) {
            body = RequestBody.create(requestBodyJson, MediaType.parse("application/json; charset=utf-8"));
        }

        Request.Builder requestBuilder = new Request.Builder()
                .url(apiUrl + path)
                .header("Authorization", "Bearer " + bearerToken);

        if (body != null) {
            requestBuilder.post(body);
        }

}
