package com.example;

import jakarta.inject.Singleton;

@Singleton
public class CustomerControllerService {
    public Customer get(String id) {
        return new Customer(id, "firstName", "lastName");
    }
}
