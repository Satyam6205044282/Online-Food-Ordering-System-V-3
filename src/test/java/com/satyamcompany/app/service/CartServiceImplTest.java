package com.satyamcompany.app.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.satyamcompany.app.dao.CartRepository;
import com.satyamcompany.app.exception.CartNotFoundException;
import com.satyamcompany.app.model.Cart;

@SpringBootTest
public class CartServiceImplTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    private Cart cart1;
    private Cart cart2;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        cart1 = new Cart("Burger", 5.99f, 2, 11.98f, null);
        cart1.setCartId(1);

        cart2 = new Cart("Pizza", 8.99f, 1, 8.99f, null);
        cart2.setCartId(2);
    }

    @Test
    public void testCreateCart() {
        Mockito.when(cartRepository.save(Mockito.any(Cart.class))).thenReturn(cart1);

        Cart createdCart = cartService.create(cart1);

        assertEquals(cart1, createdCart);
        Mockito.verify(cartRepository, Mockito.times(1)).save(cart1);
    }

    @Test
    public void testFindAllCarts() {
        Mockito.when(cartRepository.findAll()).thenReturn(Arrays.asList(cart1, cart2));

        List<Cart> carts = cartService.findAll();

        assertEquals(2, carts.size());
        assertTrue(carts.contains(cart1));
        assertTrue(carts.contains(cart2));
        Mockito.verify(cartRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testFindCartById() throws CartNotFoundException {
        Mockito.when(cartRepository.findById(1)).thenReturn(Optional.of(cart1));

        Cart foundCart = cartService.findById(1);

        assertEquals(cart1, foundCart);
        Mockito.verify(cartRepository, Mockito.times(1)).findById(1);

        assertThrows(CartNotFoundException.class, () -> {
            cartService.findById(99);
        });
    }

    @Test
    public void testDeleteCartById() throws CartNotFoundException {
        Mockito.when(cartRepository.findById(1)).thenReturn(Optional.of(cart1));

        cartService.deleteById(1);

        Mockito.verify(cartRepository, Mockito.times(1)).deleteById(1);

        assertThrows(CartNotFoundException.class, () -> {
            cartService.deleteById(99);
        });
    }

    @Test
    public void testUpdateCart() throws CartNotFoundException {
        Cart newCart = new Cart("Soda", 1.99f, 3, 5.97f, null);
        newCart.setCartId(1);

        Mockito.when(cartRepository.findById(1)).thenReturn(Optional.of(cart1));
        Mockito.when(cartRepository.save(Mockito.any(Cart.class))).thenReturn(newCart);

        Cart updatedCart = cartService.update(1, newCart);

        assertEquals(newCart, updatedCart);
        Mockito.verify(cartRepository, Mockito.times(1)).findById(1);
        Mockito.verify(cartRepository, Mockito.times(1)).save(newCart);

        assertThrows(CartNotFoundException.class, () -> {
            cartService.update(99, newCart);
        });
    }
}