package com.example.customer;

import java.util.List;
import java.util.Optional;

import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class CustomerControllerService {

    private final CustomerRepository customerRepository;

    public @NonNull Optional<Customer> get(String id) {
        return customerRepository.findById(id);
    }

    public @NonNull List<Customer> get() {
        return customerRepository.findAll()
                ;
    }
}
