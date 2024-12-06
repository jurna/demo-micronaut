package com.example.customer;

import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedEntity
@Serdeable
@ReflectiveAccess
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
}
