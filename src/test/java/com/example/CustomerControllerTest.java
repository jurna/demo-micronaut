package com.example;

import org.junit.jupiter.api.AfterEach;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @AfterEach
    void cleanup() {
        handler.getApplicationContext().close();
    }

    @Test
    void testHandler() {
        when(customerControllerService.get("1")).thenReturn(new Customer("1", "first", "last"));
        APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent();
        request.setPath("/customer/1");
        request.setHttpMethod(HttpMethod.GET.toString());
        var response = handler.handleRequest(request, new MockLambdaContext());

        assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
        assertEquals("{\"id\":\"1\",\"firstName\":\"first\",\"lastName\":\"last\"}", response.getBody());

        verify(customerControllerService).get("1");
    }

    @MockBean(CustomerControllerService.class)
    CustomerControllerService customerControllerService() {
        return mock(CustomerControllerService.class);
    }
}
