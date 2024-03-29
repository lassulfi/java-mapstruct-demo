package com.sensedia.mapstructdemo.infrastructure.h2_database.customer;

import java.util.List;
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
        final var actualModel = this.repository.findById(Objects.requireNonNull(anId));

        return actualModel.map(CUSTOMER_MAPPER::toDomain).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        final var actualModels = this.repository.findAll();

        return actualModels.stream().map(CUSTOMER_MAPPER::toDomain).toList();
    }

}
