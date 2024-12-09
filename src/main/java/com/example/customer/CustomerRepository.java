package com.example.customer;

import io.micronaut.data.mongodb.annotation.MongoAggregateQuery;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
public interface CustomerRepository extends CrudRepository<Customer, String> {
    @MongoAggregateQuery("{ $group: { _id: firstName, count: { $sum: 1 } } }")
    long count();
}
