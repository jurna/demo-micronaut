package com.example.customer;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record CustomerView(String id, String firstName, String lastName) {
}
