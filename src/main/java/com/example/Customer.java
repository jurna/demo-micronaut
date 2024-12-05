package com.example;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public record Customer(@Id String id, String firstName, String lastName) {
}
