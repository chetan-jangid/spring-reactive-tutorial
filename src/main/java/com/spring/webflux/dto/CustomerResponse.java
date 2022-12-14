package com.spring.webflux.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import reactor.core.publisher.Flux;

@Data
@AllArgsConstructor
public class CustomerResponse {
    private Flux<Customer> customers;
}
