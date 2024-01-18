package com.sensedia.mapstructdemo.usecase.customer.retrieve.get;

public record InputGetCustomerDTO(
    String id
) {
    public static InputGetCustomerDTO from(final String anIn) {
        return new InputGetCustomerDTO(anIn);
    }
}
