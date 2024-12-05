package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Customer(String id, String firstName, String lastName) {
}
