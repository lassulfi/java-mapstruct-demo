package com.sensedia.mapstructdemo.infrastructure.api.presenters.customer;

import com.sensedia.mapstructdemo.infrastructure.api.presenters._shared.AddressDTO;

public record CustomerRetrieved(
    String id,
    String name,
    AddressDTO address
) {
    
}
