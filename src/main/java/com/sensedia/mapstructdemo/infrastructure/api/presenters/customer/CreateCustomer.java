package com.sensedia.mapstructdemo.infrastructure.api.presenters.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sensedia.mapstructdemo.infrastructure.api.presenters._shared.AddressDTO;

public record CreateCustomer(
    String name,
    @JsonProperty("address") AddressDTO addressDTO
) {
    
}
