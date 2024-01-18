package com.sensedia.mapstructdemo.usecase.customer.retrieve.get;

import org.springframework.stereotype.Service;

import com.sensedia.mapstructdemo.domain.customer.repository.CustomerRepository;
import com.sensedia.mapstructdemo.infrastructure.mappers.customer.CustomerMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultGetCustomerUseCase implements GetCustomerUseCase {

    private static final CustomerMapper CUSTOMER_MAPPER = CustomerMapper.INSTANCE;


    private final CustomerRepository customerRepository;

    @Override
    public OutputGetCustomerDTO execute(InputGetCustomerDTO anIn) {
        final var actualCustomer = this.customerRepository.findById(anIn.id());

        return CUSTOMER_MAPPER.toGetCustomerOutput(actualCustomer);   
    }
    
}
