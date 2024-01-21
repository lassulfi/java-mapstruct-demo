package com.sensedia.mapstructdemo.infrastructure.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sensedia.mapstructdemo.infrastructure.api.presenters.customer.CreateCustomer;
import com.sensedia.mapstructdemo.infrastructure.api.presenters.customer.CustomerCreated;
import com.sensedia.mapstructdemo.infrastructure.api.presenters.customer.CustomerRetrieved;
import com.sensedia.mapstructdemo.infrastructure.mappers.customer.CustomerMapper;
import com.sensedia.mapstructdemo.usecase.customer.create.CreateCustomerUseCase;
import com.sensedia.mapstructdemo.usecase.customer.retrieve.get.GetCustomerUseCase;
import com.sensedia.mapstructdemo.usecase.customer.retrieve.get.InputGetCustomerDTO;
import com.sensedia.mapstructdemo.usecase.customer.retrieve.list.ListCustomersUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private static final CustomerMapper CUSTOMER_MAPPER = CustomerMapper.INSTANCE;

    private final CreateCustomerUseCase createCustomerUseCase;

    private final GetCustomerUseCase getCustomerUseCase;

    private final ListCustomersUseCase listCustomersUseCase;

    @PostMapping
    ResponseEntity<CustomerCreated> createCustomer(@RequestBody final CreateCustomer aCustomer) {
        final var anInput = CUSTOMER_MAPPER.toInput(aCustomer);

        final var actualCustomer = this.createCustomerUseCase.execute(anInput);

        final var customerToPresent = CUSTOMER_MAPPER.toPresenter(actualCustomer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerToPresent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerRetrieved> findById(@PathVariable(name = "id", value = "id") final String anId) {
        final var actualCustomer = this.getCustomerUseCase.execute(InputGetCustomerDTO.from(anId));
        return ResponseEntity.ok(CUSTOMER_MAPPER.toCustomerRetrieved(actualCustomer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerRetrieved>> findAll() {
        final var actualCustomers = this.listCustomersUseCase.execute();
        
        final var actualResponse = actualCustomers.stream().map(CUSTOMER_MAPPER::toCustomerRetrieved).toList();

        return ResponseEntity.ok(actualResponse);
    }
    
}
