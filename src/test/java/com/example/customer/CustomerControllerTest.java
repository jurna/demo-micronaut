package com.example.customer;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import io.micronaut.context.ApplicationContext;
import io.micronaut.function.aws.proxy.MockLambdaContext;
import io.micronaut.function.aws.proxy.payload1.ApiGatewayProxyRequestEventFunction;
import io.micronaut.function.aws.test.annotation.MicronautLambdaTest;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.annotation.MockBean;
import jakarta.inject.Inject;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@MicronautLambdaTest
class CustomerControllerTest {
    ApiGatewayProxyRequestEventFunction handler;

    @Inject
    CustomerControllerService customerControllerService;

    @Inject
    ApplicationContext context;

    @BeforeEach
    void setup() {
        handler = new ApiGatewayProxyRequestEventFunction(context);
    }

    @Test
    void testGetCustomer() {
        when(customerControllerService.get("1")).thenReturn(Optional.of(new Customer("1", "first", "last", List.of())));
        APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent();
        request.setPath("/customer/1");
        request.setHttpMethod(HttpMethod.GET.toString());
        var response = handler.handleRequest(request, new MockLambdaContext());

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK.getCode()));
        assertThat(response.getBody(), equalTo("{\"id\":\"1\",\"firstName\":\"first\",\"lastName\":\"last\"}"));

        verify(customerControllerService).get("1");
    }

    @Test
    void testGetCustomers() {
        when(customerControllerService.get()).thenReturn(List.of(new Customer("1", "first", "last", List.of())));
        APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent();
        request.setPath("/customer");
        request.setHttpMethod(HttpMethod.GET.toString());
        var response = handler.handleRequest(request, new MockLambdaContext());

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK.getCode()));
        assertThat(response.getBody(), equalTo("[{\"id\":\"1\",\"firstName\":\"first\",\"lastName\":\"last\"}]"));

        verify(customerControllerService).get();
    }

    @Test
    void testPostCustomer() {
        when(customerControllerService.save(new CustomerForm("first", "last"))).thenReturn(new Customer("1", "first", "last", List.of()));
        APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent();
        request.setPath("/customer");
        request.setHttpMethod(HttpMethod.POST.toString());
        request.setBody("{\"firstName\":\"first\",\"lastName\":\"last\"}");
        var response = handler.handleRequest(request, new MockLambdaContext());

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK.getCode()));
        assertThat(response.getBody(), equalTo("{\"id\":\"1\",\"firstName\":\"first\",\"lastName\":\"last\"}"));

        verify(customerControllerService).save(new CustomerForm("first", "last"));
    }

    @MockBean(CustomerControllerService.class)
    CustomerControllerService customerControllerService() {
        return mock(CustomerControllerService.class);
    }
}
