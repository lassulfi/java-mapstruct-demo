package com.sensedia.mapstructdemo.infrastructure.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sensedia.mapstructdemo.infrastructure.api.presenters.customer.CreateCustomer;
import com.sensedia.mapstructdemo.infrastructure.api.presenters.customer.CustomerCreated;
import com.sensedia.mapstructdemo.infrastructure.mappers.customer.CustomerMapper;
import com.sensedia.mapstructdemo.usecase.customer.create.CreateCustomerUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private static final CustomerMapper CUSTOMER_MAPPER = CustomerMapper.INSTANCE;

    private final CreateCustomerUseCase createCustomerUseCase;

    @PostMapping
    ResponseEntity<CustomerCreated> createCustomer(@RequestBody final CreateCustomer aCustomer) {
        final var anInput = CUSTOMER_MAPPER.toInput(aCustomer);

        final var actualCustomer = this.createCustomerUseCase.execute(anInput);

        final var customerToPresent = CUSTOMER_MAPPER.toPresenter(actualCustomer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerToPresent);
    }
}
