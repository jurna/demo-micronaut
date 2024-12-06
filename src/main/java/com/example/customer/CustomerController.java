package com.example.customer;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;
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

    @Post
    public @NonNull Customer saveCustomer(@Body @Valid CustomerForm customerForm) {
        return service.save(customerForm);
    }

}
