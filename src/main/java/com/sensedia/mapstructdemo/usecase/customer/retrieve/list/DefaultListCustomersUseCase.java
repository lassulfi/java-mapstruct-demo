package com.sensedia.mapstructdemo.usecase.customer.retrieve.list;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sensedia.mapstructdemo.domain.customer.repository.CustomerRepository;
import com.sensedia.mapstructdemo.infrastructure.mappers.customer.CustomerMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultListCustomersUseCase implements ListCustomersUseCase {

    private static final CustomerMapper CUSTOMER_MAPPER = CustomerMapper.INSTANCE;

    private final CustomerRepository customerRepository;

    @Override
    public List<OutputListCustomerDTO> execute() {
        return this.customerRepository.findAll()
            .stream()
            .map(CUSTOMER_MAPPER::toListCustomerOutput)
            .toList();
    }
    
}
