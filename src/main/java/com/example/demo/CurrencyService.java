package com.example.demo;

import com.example.demo.rest.Rates;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CurrencyService {
    private final WebClient webClient;

    public CurrencyService(WebClient.Builder builder) {
        webClient = builder
                .baseUrl("https://api.currencyapi.com/v3/latest?apikey=") // put API key here
                .build();
    }

    public Rates getLatestRates() {
        return webClient
                .get()
                .uri("/")
                .retrieve()
                .bodyToMono(Rates.class)
                .block();
    }
}
