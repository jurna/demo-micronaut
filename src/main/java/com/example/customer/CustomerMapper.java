package com.example.customer;

import io.micronaut.context.annotation.Mapper;
import jakarta.inject.Singleton;

@Singleton
public interface CustomerMapper {
    @Mapper
    Customer toCustomer(CustomerForm form);
    @Mapper
    CustomerView toView(Customer customer);
}
