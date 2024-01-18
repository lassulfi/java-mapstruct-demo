package com.sensedia.mapstructdemo.usecase._shared;

import lombok.Builder;

@Builder
public record InputAddressDTO(
    String street,
    Integer number,
    Integer zipCode,
    String city
) {
    
}
