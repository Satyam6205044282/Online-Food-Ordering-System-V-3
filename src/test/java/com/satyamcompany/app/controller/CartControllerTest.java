package com.satyamcompany.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.satyamcompany.app.dao.CartRepository;
import com.satyamcompany.app.exception.CartNotFoundException;
import com.satyamcompany.app.model.Cart;
import com.satyamcompany.app.model.Menu;
import com.satyamcompany.app.service.CartServiceImpl;

public class CartControllerTest {

    @Mock
    private CartRepository cartRepositoryMock;

    @InjectMocks
    private CartServiceImpl cartService;

    private Cart cart1;
    private Cart cart2;

	private Menu menu1;
	private Menu menu2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

//        Menu menu1 = new Menu(1, "Veg-items", "All the starter and main courses are available.");
//        Menu menu2 = new Menu(1, "Non-Veg items", "All the non veg items of the main courses are available.");

        cart1 = new Cart("menu1", 100.0f, 2, 200.0f, menu1);  
        cart2 = new Cart("menu2", 200.0f, 1, 200.0f, menu2);
    }

    @Test
    public void testCreate() {
        Mockito.when(cartRepositoryMock.save(cart1)).thenReturn(cart1);

        Cart createdCart = cartService.create(cart1);

        assertThat(createdCart).isEqualTo(cart1);
        Mockito.verify(cartRepositoryMock, Mockito.times(1)).save(cart1);
    }

    @Test
    public void testFindAll() {
        Mockito.when(cartRepositoryMock.findAll()).thenReturn(Arrays.asList(cart1, cart2));

        List<Cart> cartList = cartService.findAll();

        assertThat(cartList).hasSize(2).contains(cart1, cart2);
        Mockito.verify(cartRepositoryMock, Mockito.times(1)).findAll();
    }

    @Test
    public void testFindById() throws CartNotFoundException {
        Mockito.when(cartRepositoryMock.findById(cart1.getCartId())).thenReturn(Optional.of(cart1));

        Cart foundCart = cartService.findById(cart1.getCartId());

        assertThat(foundCart).isEqualTo(cart1);
        Mockito.verify(cartRepositoryMock, Mockito.times(1)).findById(cart1.getCartId());

        assertThrows(CartNotFoundException.class, () -> {
            cartService.findById(-1);
        });
    }

    @Test
    public void testDeleteById() throws CartNotFoundException {
        Mockito.when(cartRepositoryMock.findById(cart1.getCartId())).thenReturn(Optional.of(cart1));

        cartService.deleteById(cart1.getCartId());

        Mockito.verify(cartRepositoryMock, Mockito.times(1)).deleteById(cart1.getCartId());

        assertThrows(CartNotFoundException.class, () -> {
            cartService.deleteById(-1);
        });
    }

    @Test
    public void testUpdate() throws CartNotFoundException {
        Mockito.when(cartRepositoryMock.findById(cart1.getCartId())).thenReturn(Optional.of(cart1));

        Cart updatedCart = new Cart("menu1", 100.0f, 3, 300.0f, cart1.getMenu());
        Mockito.when(cartRepositoryMock.save(updatedCart)).thenReturn(updatedCart);

        Cart returnedCart = cartService.update(cart1.getCartId(), updatedCart);

        assertEquals(updatedCart.getQuantity(), returnedCart.getQuantity());
        Mockito.verify(cartRepositoryMock, Mockito.times(1)).findById(cart1.getCartId());
        Mockito.verify(cartRepositoryMock, Mockito.times(1)).findById(cart1.getCartId());
        
        assertThrows(CartNotFoundException.class, () -> {
            cartService.update(1, returnedCart); 
        });
    }
}