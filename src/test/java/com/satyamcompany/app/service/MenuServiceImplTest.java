package com.satyamcompany.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.satyamcompany.app.dao.MenuRepository;
import com.satyamcompany.app.exception.MenuNotFoundException;
import com.satyamcompany.app.model.Menu;

@ExtendWith(MockitoExtension.class)
public class MenuServiceImplTest {

    @InjectMocks
    private MenuServiceImpl service;

    @Mock
    private MenuRepository repository;

    @Test
    public void testCreateMenu() {
        // Given
        Menu menu = new Menu("Pizza", 9.99f);
        Mockito.when(repository.save(Mockito.any(Menu.class))).thenReturn(menu);

        // When
        Menu result = service.create(menu);

        // Then
        assertNotNull(result);
        assertEquals(menu, result);
    }

    @Test
    public void testFindAllMenus() {
        // Given
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("Pizza", 9.99f));
        menus.add(new Menu("Burger", 6.99f));
        Mockito.when(repository.findAll()).thenReturn(menus);

        // When
        List<Menu> result = service.findAll();

        // Then
        assertNotNull(result);
        assertEquals(menus.size(), result.size());
        assertEquals(menus.get(0), result.get(0));
        assertEquals(menus.get(1), result.get(1));
    }

    @Test
    public void testFindByMenuName() throws MenuNotFoundException {
        // Given
        String menuName = "Pizza";
        Menu menu = new Menu(menuName, 9.99f);
        Mockito.when(repository.findByMenuName(Mockito.anyString())).thenReturn(java.util.Optional.of(menu));

        // When
        Menu result = service.findByMenuName(menuName);

        // Then
        assertNotNull(result);
        assertEquals(menu, result);
    }

    @Test
    public void testFindByInvalidMenuName() {
        // Given
        String menuName = "Pasta";
        Mockito.when(repository.findByMenuName(Mockito.anyString())).thenReturn(java.util.Optional.empty());

        // When and Then
        assertThrows(MenuNotFoundException.class, () -> service.findByMenuName(menuName));
    }

}