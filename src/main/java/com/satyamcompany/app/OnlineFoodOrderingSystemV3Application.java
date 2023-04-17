package com.satyamcompany.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.satyamcompany.app.service.CartServiceImpl;
import com.satyamcompany.app.service.CustomerService;
import com.satyamcompany.app.service.CustomerServiceImpl;
import com.satyamcompany.app.service.MenuServiceImpl;
import com.satyamcompany.app.service.MenuTypeServiceImpl;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@SpringBootApplication
public class OnlineFoodOrderingSystemV3Application {

	public static void main(String[] args) {
		log.info("START");
		ConfigurableApplicationContext ctx= SpringApplication.run(OnlineFoodOrderingSystemV3Application.class, args);
		
		
		CustomerService  customerService = ctx.getBean(CustomerServiceImpl.class);
		log.debug("customerService : {}",customerService);
		
		MenuServiceImpl  menuService = ctx.getBean(MenuServiceImpl.class);
		log.debug("menuService : {}",menuService);	
		
		MenuTypeServiceImpl  menuTypeService = ctx.getBean(MenuTypeServiceImpl.class);
		log.debug("menuTypeService : {}",menuTypeService);
		
		CartServiceImpl  cartService = ctx.getBean(CartServiceImpl.class);
		log.debug("cartService : {}",cartService);
		
		
		log.info("END");
		
	}

}
