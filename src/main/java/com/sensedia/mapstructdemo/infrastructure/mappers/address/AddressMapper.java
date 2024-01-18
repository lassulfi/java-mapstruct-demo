package com.sensedia.mapstructdemo.infrastructure.mappers.address;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sensedia.mapstructdemo.domain.customer.value_objects.Address;
import com.sensedia.mapstructdemo.usecase._shared.InputAddressDTO;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address fromInput(final InputAddressDTO anIn);

}
