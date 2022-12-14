package com.spring.webflux.repository;

import com.spring.webflux.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Annotating the class with @Component instead of @Repository
 * as we will be using static data for learning purposes.
 */
@Component
@Slf4j
public class CustomerRepository {
    public Flux<Customer> getCustomers() {
        return Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> log.info("Processing : {}", i))
                .map(i -> new Customer(i, "Customer_" + i));
    }

    public Flux<Customer> getCustomersWithoutDelay() {
        return Flux.range(1, 5)
                .doOnNext(i -> log.info("Processing : {}", i))
                .map(i -> new Customer(i, "Customer_" + i));
    }
}
