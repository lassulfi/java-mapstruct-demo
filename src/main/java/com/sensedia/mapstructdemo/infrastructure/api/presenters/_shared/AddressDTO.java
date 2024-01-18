package com.sensedia.mapstructdemo.infrastructure.api.presenters._shared;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record AddressDTO(
    String street,
    Integer number,
    @JsonProperty("zip_code") Integer zipCode,
    String city
) {
    
}
