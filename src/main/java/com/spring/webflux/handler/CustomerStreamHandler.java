package com.spring.webflux.handler;

import com.spring.webflux.dto.Customer;
import com.spring.webflux.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CustomerStreamHandler {
    private final CustomerService customerService;

    public Mono<ServerResponse> getCustomer() {
        Flux<Customer> customers = customerService.getCustomers();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customers, Customer.class);
    }
}
