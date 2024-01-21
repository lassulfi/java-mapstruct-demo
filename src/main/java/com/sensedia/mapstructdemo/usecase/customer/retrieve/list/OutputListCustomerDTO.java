package com.sensedia.mapstructdemo.usecase.customer.retrieve.list;

import com.sensedia.mapstructdemo.infrastructure.api.presenters._shared.AddressDTO;

public record OutputListCustomerDTO(
    String id,
    String name,
    AddressDTO address
) {
    
}
