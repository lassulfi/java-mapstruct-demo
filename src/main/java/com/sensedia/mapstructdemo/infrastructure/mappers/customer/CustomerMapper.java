package com.sensedia.mapstructdemo.infrastructure.mappers.customer;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sensedia.mapstructdemo.domain.customer.Customer;
import com.sensedia.mapstructdemo.infrastructure.api.presenters.customer.CreateCustomer;
import com.sensedia.mapstructdemo.infrastructure.api.presenters.customer.CustomerCreated;
import com.sensedia.mapstructdemo.infrastructure.api.presenters.customer.CustomerRetrieved;
import com.sensedia.mapstructdemo.infrastructure.h2_database.customer.CustomerModel;
import com.sensedia.mapstructdemo.usecase.customer.create.InputCreateCustomerDTO;
import com.sensedia.mapstructdemo.usecase.customer.create.OutputCreateCustomerDTO;
import com.sensedia.mapstructdemo.usecase.customer.retrieve.get.OutputGetCustomerDTO;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @InheritConfiguration
    @Mapping(source = "address.street", target = "street")
    @Mapping(source = "address.number", target = "number")
    @Mapping(source = "address.zipCode", target = "zipCode")
    @Mapping(source = "address.city", target = "city")
    CustomerModel toModel(final Customer aCustomer);

    @Mapping(source = "name", target = "name")
    Customer fromInput(final InputCreateCustomerDTO anIn);

    @Mapping(source = "street", target = "address.street")
    @Mapping(source = "number", target = "address.number")
    @Mapping(source = "zipCode", target = "address.zipCode")
    @Mapping(source = "city", target = "address.city")
    Customer toDomain(final CustomerModel aModel);
    
    OutputCreateCustomerDTO toCreateCustomerOutput(final Customer aCustomer);

    InputCreateCustomerDTO toInput(final CreateCustomer anIn);

    CustomerCreated toPresenter(final OutputCreateCustomerDTO anOutput);

    OutputGetCustomerDTO toGetCustomerOutput(final Customer aCustomer);

    CustomerRetrieved toCustomerRetrieved(final OutputGetCustomerDTO anOutput);
}
