package com.example.customer;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotEmpty;

@Serdeable
public record CustomerForm(@NotEmpty String firstName, @NotEmpty String lastName) {
}
