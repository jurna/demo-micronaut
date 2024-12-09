package com.example.customer;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record CustomerView(String id, String firstName, String lastName) {
}
