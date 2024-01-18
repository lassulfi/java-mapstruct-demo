package com.sensedia.mapstructdemo.infrastructure.h2_database.customer;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.sensedia.mapstructdemo.domain.customer.Customer;
import com.sensedia.mapstructdemo.domain.customer.repository.CustomerRepository;
import com.sensedia.mapstructdemo.infrastructure.mappers.customer.CustomerMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerH2RepositoryAdapter implements CustomerRepository {

    private static final CustomerMapper CUSTOMER_MAPPER = CustomerMapper.INSTANCE;

    private final CustomerH2Repository repository;
    
    @Override
    public Customer create(Customer aCustomer) {
        final var aModel = CUSTOMER_MAPPER.toModel(aCustomer);

        final var actualModel = this.repository.save(Objects.requireNonNull(aModel));

        return CUSTOMER_MAPPER.toDomain(actualModel);
    }

    @Override
    public Customer findById(String anId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Customer findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
