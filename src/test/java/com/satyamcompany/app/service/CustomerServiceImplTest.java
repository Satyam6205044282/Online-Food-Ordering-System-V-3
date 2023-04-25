package com.satyamcompany.app.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.satyamcompany.app.dao.CustomerRepository;
import com.satyamcompany.app.exception.CustomerNotFoundException;
import com.satyamcompany.app.model.Customer;

class CustomerServiceImplTest {

    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerServiceImpl service;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer("John", "Doe", "john.doe@gmail.com", "1234567890", "johndoe", "John123");
        Mockito.when(repository.save(Mockito.any(Customer.class))).thenReturn(customer);

        Customer createdCustomer = service.create(customer);

        assertEquals(customer, createdCustomer);
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(Customer.class));
    }

    @Test
    void testFindAllCustomers() {
        List<Customer> customers = Arrays.asList(
            new Customer("John", "Doe", "john.doe@gmail.com", "1234567890", "johndoe", "John123"),
            new Customer("Jane", "Doe", "jane.doe@gmail.com", "0987654321", "janedoe", "John123")
        );
        Mockito.when(repository.findAll()).thenReturn(customers);

        List<Customer> foundCustomers = service.findAll();

        assertEquals(customers, foundCustomers);
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void testFindCustomerById() throws CustomerNotFoundException {
        int customerId = 1;
        Customer customer = new Customer("John", "Doe", "john.doe@gmail.com", "1234567890", "johndoe", "John123");
        Mockito.when(repository.findById(customerId)).thenReturn(Optional.of(customer));

        Customer foundCustomer = service.findById(customerId);

        assertEquals(customer, foundCustomer);
        Mockito.verify(repository, Mockito.times(1)).findById(customerId);
    }

    @Test
    void testFindCustomerByIdNotFoundException() {
        int customerId = 1;
        Mockito.when(repository.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> service.findById(customerId));
        Mockito.verify(repository, Mockito.times(1)).findById(customerId);
    }

    @Test
    void testDeleteCustomerById() throws CustomerNotFoundException {
        int customerId = 1;
        Customer customer = new Customer("John", "Doe", "john.doe@gmail.com", "1234567890", "johndoe", "John123");
        Mockito.when(repository.findById(customerId)).thenReturn(Optional.of(customer));

        service.deleteById(customerId);

        Mockito.verify(repository, Mockito.times(1)).deleteById(customerId);
    }

    @Test
    void testDeleteCustomerByIdNotFoundException() {
        int customerId = 1;
        Mockito.when(repository.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> service.deleteById(customerId));
        Mockito.verify(repository, Mockito.times(0)).deleteById(customerId);
    }

    @Disabled
    @Test
    void testUpdateCustomer(){
        
    }
}