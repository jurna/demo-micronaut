package com.example.customer;

import org.junit.jupiter.api.Test;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@MicronautTest
public class CustomerMapperTest {
    @Inject
    CustomerMapper customerMapper;

    @Test
    void testToCustomer() {
        CustomerForm form = new CustomerForm("John", "Doe");

        Customer customer = customerMapper.toCustomer(form);

        assertThat(customer, notNullValue());
        assertThat(customer.getFirstName(), equalTo("John"));
        assertThat(customer.getLastName(), equalTo("Doe"));
    }

    @Test
    void testToView() {
        Customer customer = new Customer("1", "John", "Doe");

        CustomerView view = customerMapper.toView(customer);

        assertThat(view, notNullValue());
        assertThat(view.id(), equalTo("1"));
        assertThat(view.firstName(), equalTo("John"));
        assertThat(view.lastName(), equalTo("Doe"));
    }

}
