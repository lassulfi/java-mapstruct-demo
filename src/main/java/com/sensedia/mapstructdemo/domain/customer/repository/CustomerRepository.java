package com.sensedia.mapstructdemo.domain.customer.repository;

import com.sensedia.mapstructdemo.domain.customer.Customer;

public interface CustomerRepository {
    Customer create(final Customer aCustomer);

    Customer findById(final String anId);

    Customer findAll();
}
