package com.satyamcompany.app.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.satyamcompany.app.exception.MenuNotFoundException;
import com.satyamcompany.app.model.Menu;
import com.satyamcompany.app.service.MenuService;

@ExtendWith(MockitoExtension.class)
class MenuControllerTest {

	@InjectMocks
	private MenuController menuController;

	@Mock
	private MenuService menuService;

	private List<Menu> menuList;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		Menu menu1 = new Menu(1, "Menu1", 10.0f, null);
		Menu menu2 = new Menu(2, "Menu2", 20.0f, null);

		menuList = Arrays.asList(menu1, menu2);
	}

	@Test
	void testFindAll() {
		when(menuService.findAll()).thenReturn(menuList);

		List<Menu> result = menuController.findAll();

		assertThat(result, is(menuList));
	}

	@Test
	void testFindAllV1() {
		when(menuService.findAll()).thenReturn(menuList);

		ResponseEntity<List<Menu>> response = menuController.findAllV1();

		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody(), is(menuList));
	}

	@Test
	void testFindByMenuName() {
		String menuName = "Menu1";
		Menu menu = new Menu(1, menuName, 10.0f, null);

		when(menuService.findByMenuName(menuName)).thenReturn(menu);

		Menu result = menuController.findByMenuName(menuName);

		assertThat(result, is(menu));
	}

	@Test
	void testFindByMenuNameV1() throws MenuNotFoundException {
		String menuName = "Menu1";
		Menu menu = new Menu(1, menuName, 10.0f, null);

		when(menuService.findByMenuName(menuName)).thenReturn(menu);

		ResponseEntity<Menu> response = menuController.findByMenuNameV1(menuName);

		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody(), is(menu));
	}

	@Test
	void testCreate() {
		String menuName = "Menu3";
		float price = 30.0f;
		Menu menu = new Menu(menuName, price);

		when(menuService.create(menu)).thenReturn(menu);

		Menu result = menuController.create(menu);

		assertThat(result.getMenuName(), is(menuName));
		assertThat(result.getPrice(), is(price));
	}

	@Test
	void testCreateV1() {
		String menuName = "Menu3";
		float price = 30.0f;
		Menu menu = new Menu(menuName, price);

		when(menuService.create(menu)).thenReturn(menu);

		Menu result = menuController.createV1(menu);

		assertThat(result.getMenuName(), is(menuName));
		assertThat(result.getPrice(), is(price));
	}

}