package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.AllArgsConstructor;

@Controller("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerControllerService service;

    @Get("/{id}")
    public Customer getCustomer(String id) {
        return service.get(id);
    }
}
