package com.sensedia.mapstructdemo.usecase.customer.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sensedia.mapstructdemo.domain.customer.Customer;
import com.sensedia.mapstructdemo.domain.customer.repository.CustomerRepository;
import com.sensedia.mapstructdemo.domain.customer.value_objects.Address;
import com.sensedia.mapstructdemo.usecase._shared.InputAddressDTO;

@ExtendWith(MockitoExtension.class)
class DefaultCreateCustomerUseCaseTest {
    
    @InjectMocks
    private DefaultCreateCustomerUseCase useCase;

    @Mock
    private CustomerRepository customerRepository;

    private InputCreateCustomerDTO actualInput;

    @Captor
    private ArgumentCaptor<Customer> customerCaptor;

    private OutputCreateCustomerDTO actualOutput;

    @Test
    void givenAValidInput_whenCallCreateCustomerUseCase_thenShouldCreateAValidCustomer() {
        givenAValidInput();
        givenCustomerRepositoryCreateMethodReturnsAValidCustomer();
        whenCallUseCaseExecuteMethod();
        thenExpectCustomerRepositoryCreateMethodToHaveBeenCalled();
        thenExpectAValidOutput();
    }

    private void givenAValidInput() {
        this.actualInput = InputCreateCustomerDTO.builder()
            .name("João da Silva")
            .addressDTO(InputAddressDTO.builder()
                    .city("São Paulo")
                    .number(1)
                    .street("Rua dos Colibris")
                    .zipCode(1300900)
                .build())
        .build();
    }

    private void givenCustomerRepositoryCreateMethodReturnsAValidCustomer() {
        final var actualCustomer = Customer.newCustomer("João da Silva");
        actualCustomer.changeAddress(Address.newAddress("Rua dos Colibris", 1, 13900100, "São Paulo"))
            .activate();
        
        doReturn(actualCustomer)
            .when(this.customerRepository).create(any(Customer.class));
    }

    private void whenCallUseCaseExecuteMethod() {
        this.actualOutput = this.useCase.execute(this.actualInput);
    }

    private void thenExpectCustomerRepositoryCreateMethodToHaveBeenCalled() {
        verify(this.customerRepository, times(1)).create(customerCaptor.capture());

        final var capturedCustomer = customerCaptor.getValue();
        assertNotNull(capturedCustomer);
        assertNotNull(capturedCustomer.getId());
        assertEquals(this.actualInput.name(), capturedCustomer.getName());
        assertEquals(this.actualInput.addressDTO().city(), capturedCustomer.getAddress().getCity());
        assertEquals(this.actualInput.addressDTO().number(), capturedCustomer.getAddress().getNumber());
        assertEquals(this.actualInput.addressDTO().street(), capturedCustomer.getAddress().getStreet());
        assertEquals(this.actualInput.addressDTO().zipCode(), capturedCustomer.getAddress().getZipCode());
        assertTrue(capturedCustomer.getActive());
    }

    private void thenExpectAValidOutput() {
        assertNotNull(this.actualOutput);
        assertNotNull(this.actualOutput.id());
        assertTrue(this.actualOutput.id().length() > 0);
    }
}
