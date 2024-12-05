package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/customer")
public class CustomerController {

    @Get("/{id}")
    public Customer getCustomer(String id) {
        return new Customer(id, "first", "last");
    }
}
