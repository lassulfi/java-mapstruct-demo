package com.sensedia.mapstructdemo.usecase.customer.create;

import com.sensedia.mapstructdemo.usecase._shared.InputAddressDTO;

import lombok.Builder;

@Builder
public record InputCreateCustomerDTO(
    String name,
    InputAddressDTO addressDTO
) {
    
}
