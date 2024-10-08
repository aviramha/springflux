package org.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExternalServiceClient {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public ExternalServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<String> getDataFromOtherService(String endpointUrl) {
        return webClientBuilder.build()
                .get()
                .uri(endpointUrl) // The external service URL
                .retrieve()
                .bodyToMono(String.class); // You can change this to the type you expect
    }
}
