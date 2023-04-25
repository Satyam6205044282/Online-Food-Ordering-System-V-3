package com.satyamcompany.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.satyamcompany.app.exception.CustomerNotFoundException;
import com.satyamcompany.app.exception.OrderNotFoundException;
import com.satyamcompany.app.model.Customer;
import com.satyamcompany.app.model.Order;

@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    
    @Test
    public void testCreateOrder() throws CustomerNotFoundException {
        // Create a customer to associate with the order
        Customer customer = new Customer("John", "Doe", "john.doe@gmail.com", "1234567890", "johndoe", "John123");

        // Create an order
        Order order = new Order("2023-04-25", "50.00", customer);
        Order createdOrder = orderService.create(order);

        assertNotNull(createdOrder);
        assertNotNull(createdOrder.getOrderId());
        assertEquals(createdOrder.getOrderDate(), "2023-04-25");
        assertEquals(createdOrder.getTotalAmount(), "50.00");
        assertNotNull(createdOrder.getCustomer());
        assertEquals(createdOrder.getCustomer().getCustomerId(), customer.getCustomerId());
    }

    @Test
    public void testFindAllOrders() {
        List<Order> orders = orderService.findAll();

        assertNotNull(orders);
        assertTrue(orders.size() > 0);
    }

    @Test
    public void testFindOrderById() throws OrderNotFoundException {
        // Find an existing order by ID
        Order existingOrder = orderService.findAll().get(0);

        Order foundOrder = orderService.findById(existingOrder.getOrderId());

        assertNotNull(foundOrder);
        assertEquals(existingOrder.getOrderId(), foundOrder.getOrderId());
    }

   
}