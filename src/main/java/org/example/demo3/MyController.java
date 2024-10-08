package org.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MyController {

    private final ExternalServiceClient externalServiceClient;

    @Autowired
    public MyController(ExternalServiceClient externalServiceClient) {
        this.externalServiceClient = externalServiceClient;
    }

    @GetMapping("/fetch-data")
    public Mono<String> fetchData() {
        String externalServiceUrl = "http://ip-info/health"; // Replace with your actual service URL
        return externalServiceClient.getDataFromOtherService(externalServiceUrl);
    }
}