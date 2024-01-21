package com.sensedia.mapstructdemo.domain.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.sensedia.mapstructdemo.domain.customer.value_objects.Address;

public class CustomerTest {
    
    private String actualName;

    private Customer actualCustomer;

    private Address actualAddress;

    @Test
    void givenAValidName_WhenCallNewCustomer_thenShouldCreateANewCustomer() {
        givenAValidName();
        whenCallNewCustomer();
        thenShouldCreateANewCustomer();
    }

    @Test
    void givenAValidAddress_whenCallChangeAddress_thenShouldChangeCustomersAddress() {
        givenAValidCustomer();
        givenAValidAddress();
        whenCallChangeAddress();
        thenShouldChangeCustomersAddress();
    }

    @Test
    void givenAValidCustomer_whenCallActivate_thenShouldActivateCustomer() {
        givenAValidCustomer();
        whenCallActivate();
        thenShouldActivateCustomer();
    }

    @Test
    void givenAValidCustomer_whenCallDeactivate_thenShouldDeactivateCustomer() {
        givenAValidCustomer();
        whenCallDeactivate();
        thenShouldDeactivateCustomer();
    }

    // GIVEN METHODS

    private void givenAValidName() {
        this.actualName = "João da Silva";
    }

    private void givenAValidCustomer() {
        givenAValidName();
        this.actualCustomer = Customer.newCustomer(this.actualName);
    }

    private void givenAValidAddress() {
        this.actualAddress = new Address("Rua um", 1, 1300900, "Campinas");
    }

    // WHEN METHODS

    private void whenCallNewCustomer() {
        this.actualCustomer = Customer.newCustomer(this.actualName);
    }

    private void whenCallChangeAddress() {
        this.actualCustomer.changeAddress(this.actualAddress);
    }

    private void whenCallActivate() {
        this.actualCustomer.activate();
    }

    private void whenCallDeactivate() {
        this.actualCustomer.deactivate();
    }

    // THEN METHODS

    private void thenShouldCreateANewCustomer() {
        assertNotNull(this.actualCustomer);
        assertNotNull(this.actualCustomer.getId());
        assertFalse(this.actualCustomer.getId().isBlank());
        assertEquals(this.actualName, this.actualCustomer.getName());
    }

    private void thenShouldChangeCustomersAddress() {
        assertNotNull(this.actualCustomer.getAddress());
        assertEquals(this.actualAddress.getStreet(), this.actualCustomer.getAddress().getStreet());
        assertEquals(this.actualAddress.getNumber(), this.actualCustomer.getAddress().getNumber());
        assertEquals(this.actualAddress.getZipCode(), this.actualCustomer.getAddress().getZipCode());
        assertEquals(this.actualAddress.getCity(), this.actualCustomer.getAddress().getCity());
    }

    private void thenShouldActivateCustomer() {
        assertTrue(this.actualCustomer.getActive());
    }

    private void thenShouldDeactivateCustomer() {
        assertFalse(this.actualCustomer.getActive());
    }
}
