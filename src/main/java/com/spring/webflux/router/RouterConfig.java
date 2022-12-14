package com.spring.webflux.router;

import com.spring.webflux.handler.CustomerHandler;
import com.spring.webflux.handler.CustomerStreamHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RouterConfig {
    private final CustomerHandler customerHandler;
    private final CustomerStreamHandler customerStreamHandler;

    @Bean
    public RouterFunction<ServerResponse> routers() {
        return route(GET("/router/customers"), request -> customerHandler.getCustomers())
                .and(route(GET("/router/customers/stream"), request -> customerStreamHandler.getCustomer()));
    }
}
