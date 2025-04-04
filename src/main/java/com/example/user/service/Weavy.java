package com.example.user.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
}
