package com.example.customer;

import org.junit.jupiter.api.Test;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class CustomerRepositoryTest {

    @Inject
    CustomerRepository customerRepository;

    @Test
    public void save() {
        Customer customer = new Customer("1", "first", "last");
        var saved = customerRepository.save(customer);

        var loaded = customerRepository.findById(saved.id());

        assertTrue(loaded.isPresent());
    }

}
