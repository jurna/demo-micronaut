package com.example.customer;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Customer {
    @Id
    @GeneratedValue
    private String id;
    private String firstName;
    private String lastName;
}
