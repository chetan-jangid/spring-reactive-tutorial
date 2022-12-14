package com.spring.webflux.handler;

import com.spring.webflux.dto.Customer;
import com.spring.webflux.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CustomerHandler {
    private final CustomerService customerService;

    public Mono<ServerResponse> getCustomers() {
        Flux<Customer> customers = customerService.getCustomersWithoutDelay();
        return ServerResponse.ok()
                .body(customers, Customer.class);
    }
}
