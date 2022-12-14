package com.spring.webflux.service;

import com.spring.webflux.dto.Customer;
import com.spring.webflux.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Flux<Customer> getCustomers() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerRepository.getCustomers();
        long end = System.currentTimeMillis();
        log.info("Total execution time : {}", (end - start));
        return customers;
    }

    public Flux<Customer> getCustomersWithoutDelay() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerRepository.getCustomersWithoutDelay();
        long end = System.currentTimeMillis();
        log.info("Total execution time : {}", (end - start));
        return customers;
    }
}
