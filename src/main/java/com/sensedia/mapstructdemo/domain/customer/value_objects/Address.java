package com.sensedia.mapstructdemo.domain.customer.value_objects;

import com.sensedia.mapstructdemo.domain._shared.ValueObect;

import lombok.Data;

@Data
public class Address extends ValueObect {
    
    private String street;

    private Integer number;

    private Integer zipCode;

    private String city;

    public Address(final String aStreet, final Integer aNumber, final Integer aZipCode, final String aCity) {
        super();
        this.street = aStreet;
        this.number = aNumber;
        this.zipCode = aZipCode;
        this.city = aCity;
    }

    public static Address newAddress(final String aStreet, final Integer aNumber, final Integer aZipCode, final String aCity) {
        return new Address(aStreet, aNumber, aZipCode, aCity);
    }
}
