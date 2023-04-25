package com.satyamcompany.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.satyamcompany.app.model.Customer;
import com.satyamcompany.app.service.CustomerService;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testFindAll() throws Exception {
        Customer customer1 = new Customer("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "password");
        Customer customer2 = new Customer("Jane", "Doe", "jane.doe@example.com", "0987654321", "janedoe", "password");
        List<Customer> customers = Arrays.asList(customer1, customer2);
        when(customerService.findAll()).thenReturn(customers);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String expectedResponse = mapper.writeValueAsString(customers);
        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }

    @Test
    public void testFindById() throws Exception {
        Customer customer = new Customer("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "password");
        when(customerService.findById(1)).thenReturn(customer);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String expectedResponse = mapper.writeValueAsString(customer);
        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }

    @Test
    public void testCreate() throws Exception {
        Customer customer = new Customer("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "password");
        String json = mapper.writeValueAsString(customer);
        when(customerService.create(customer)).thenReturn(customer);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andReturn();
        String expectedResponse = mapper.writeValueAsString(customer);
        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }

    @Test
    public void testUpdate() throws Exception {
        Customer customer = new Customer("John", "Doe", "john.doe@example.com", "1234567890", "johndoe", "password");
        String json = mapper.writeValueAsString(customer);
        when(customerService.update(1, customer)).thenReturn(customer);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/customers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andReturn();
        String expectedResponse = mapper.writeValueAsString(customer);
        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }

    @Disabled   
    @Test
    public void testDeleteById() {
        
    }
}