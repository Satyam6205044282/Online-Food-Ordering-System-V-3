package com.satyamcompany.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.satyamcompany.app.exception.MenuTypeNotFoundException;
import com.satyamcompany.app.model.MenuType;

@SpringBootTest
@ActiveProfiles("test")
public class MenuTypeServiceImplTest {

    @Autowired
    private MenuTypeService menuTypeService;

    private MenuType menuType1;

    @BeforeEach
    public void setup() {
        menuType1 = new MenuType("Beverages", "Non-alcoholic drinks");
    }

    @Test
    @DisplayName("Create MenuType Test")
    public void createMenuTypeTest() {
        MenuType savedMenuType = menuTypeService.create(menuType1);
        assertThat(savedMenuType).isNotNull();
        assertThat(savedMenuType.getTypeName()).isEqualTo(menuType1.getTypeName());
        assertThat(savedMenuType.getDescription()).isEqualTo(menuType1.getDescription());
    }

    @Test
    @DisplayName("Find All MenuTypes Test")
    public void findAllMenuTypesTest() {
        List<MenuType> menuTypes = menuTypeService.findAll();
        assertThat(menuTypes).isNotNull().isNotEmpty();
    }

    @Test
    @DisplayName("Find MenuType By Type-Name Test")
    public void findMenuTypeByTypeNameTest() throws MenuTypeNotFoundException {
        menuTypeService.create(menuType1);
        MenuType foundMenuType = menuTypeService.findByTypeName(menuType1.getTypeName());
        assertThat(foundMenuType).isNotNull();
        assertThat(foundMenuType.getTypeName()).isEqualTo(menuType1.getTypeName());
        assertThat(foundMenuType.getDescription()).isEqualTo(menuType1.getDescription());
    }

    @Test
    @DisplayName("Find MenuType By Non-Existing Type-Name Test")
    public void findMenuTypeByNonExistingTypeNameTest() {
        assertThrows(MenuTypeNotFoundException.class, () -> {
            menuTypeService.findByTypeName("InvalidTypeName");
        });
    }
}