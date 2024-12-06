package com.example.customer;

import java.util.List;
import java.util.Optional;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.AllArgsConstructor;

@Controller("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerControllerService service;

    @Get
    public @NonNull List<Customer> getCustomers() {
        return service.get();
    }

    @Get("/{id}")
    public @NonNull Optional<Customer> getCustomer(String id) {
        return service.get(id);
    }
}
