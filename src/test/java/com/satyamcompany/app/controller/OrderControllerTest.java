package com.satyamcompany.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.satyamcompany.app.exception.OrderNotFoundException;
import com.satyamcompany.app.model.Customer;
import com.satyamcompany.app.model.Order;
import com.satyamcompany.app.service.OrderService;

@SpringBootTest
public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    public OrderControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Order order1 = new Order(1, "2023-04-25", "100", new Customer());
        Order order2 = new Order(2, "2023-04-26", "200", new Customer());
        List<Order> orders = Arrays.asList(order1, order2);

        when(orderService.findAll()).thenReturn(orders);

        List<Order> result = orderController.findAll();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testFindById() throws OrderNotFoundException {
        Order order = new Order(1, "2023-04-25", "100", new Customer());

        when(orderService.findById(1)).thenReturn(order);

        Order result = orderController.findById(1);
        assertNotNull(result);
        assertEquals(1, result.getOrderId());
        assertEquals("2023-04-25", result.getOrderDate());
        assertEquals("100", result.getTotalAmount());
    }

    @Test
    public void testFindByIdNotFound() {
        when(orderService.findById(1)).thenThrow(new OrderNotFoundException("Order not found"));

        try {
            orderController.findById(1);
        } catch (Exception e) {
            assertEquals("Order not found", e.getMessage());
        }
    }

    @Test
    public void testCreate() {
        Order order = new Order(1, "2023-04-25", "100", new Customer());

        when(orderService.create(order)).thenReturn(order);

        Order result = orderController.create(order);
        assertNotNull(result);
        assertEquals(1, result.getOrderId());
        assertEquals("2023-04-25", result.getOrderDate());
        assertEquals("100", result.getTotalAmount());
    }

    @Test
    public void testFindAllV1() {
        Order order1 = new Order(1, "2023-04-25", "100", new Customer());
        Order order2 = new Order(2, "2023-04-26", "200", new Customer());
        List<Order> orders = Arrays.asList(order1, order2);

        when(orderService.findAll()).thenReturn(orders);

        ResponseEntity<List<Order>> result = orderController.findAllV1();
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(2, result.getBody().size());
    }

}