package com.sensedia.mapstructdemo.domain.customer;

import java.util.UUID;

import com.sensedia.mapstructdemo.domain._shared.Entity;
import com.sensedia.mapstructdemo.domain.customer.value_objects.Address;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends Entity {
    
    private String name;

    private Address address;

    private Boolean active;
    
    public Customer(final String anId, final String aName) {
        super();
        this.id = anId;
        this.name = aName;
    }

    public static Customer newCustomer(final String aName) {
        return new Customer(UUID.randomUUID().toString(), aName);
    }

    public Customer changeName(final String aName) {
        this.name = aName;

        return this;
    }

    public Customer changeAddress(final Address anAddress) {
        this.address = anAddress;

        return this;
    }

    public Customer activate() {
        this.active = true;

        return this;
    }

    public Customer deactivate() {
        this.active = false;

        return this;
    }
}
