package com.sensedia.mapstructdemo.usecase.customer.create;

import org.springframework.stereotype.Service;

import com.sensedia.mapstructdemo.domain.customer.Customer;
import com.sensedia.mapstructdemo.domain.customer.repository.CustomerRepository;
import com.sensedia.mapstructdemo.infrastructure.mappers.address.AddressMapper;
import com.sensedia.mapstructdemo.infrastructure.mappers.customer.CustomerMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultCreateCustomerUseCase implements CreateCustomerUseCase {

    private static final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    private final CustomerRepository repository;

    @Override
    public OutputCreateCustomerDTO execute(InputCreateCustomerDTO anIn) {

        final var aCustomer = Customer.newCustomer(anIn.name());

        final var anAddress = AddressMapper.INSTANCE.fromInput(anIn.addressDTO());

        aCustomer.changeAddress(anAddress)
            .activate();

        final var actualCustomer = this.repository.create(aCustomer);

        return customerMapper.toCreateCustomerOutput(actualCustomer);
    }

}
