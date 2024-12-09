package com.example.customer;

import java.util.List;

import io.micronaut.data.mongodb.annotation.MongoFindQuery;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    @MongoFindQuery(filter = "{}", project = "{ changeLogs: 0}")
    List<CustomerView> viewFindAll();
}
