package com.sensedia.mapstructdemo.usecase.customer.retrieve.get;

import com.sensedia.mapstructdemo.infrastructure.api.presenters._shared.AddressDTO;

public record OutputGetCustomerDTO(
    String id,
    String name,
    AddressDTO address
) {
    
}
