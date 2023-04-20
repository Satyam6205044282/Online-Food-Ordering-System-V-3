package com.satyamcompany.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.satyamcompany.app.service.CartService;
import com.satyamcompany.app.service.CartServiceImpl;
import com.satyamcompany.app.service.CustomerService;
import com.satyamcompany.app.service.CustomerServiceImpl;
import com.satyamcompany.app.service.MenuService;
import com.satyamcompany.app.service.MenuServiceImpl;
import com.satyamcompany.app.service.MenuTypeService;
import com.satyamcompany.app.service.MenuTypeServiceImpl;
import com.satyamcompany.app.service.OrderService;
import com.satyamcompany.app.service.OrderServiceImpl;
import com.satyamcompany.app.service.RatingService;
import com.satyamcompany.app.service.RatingServiceImpl;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@SpringBootApplication
public class OnlineFoodOrderingSystemV3Application {

	public static void main(String[] args) {
		log.info("START");
		ConfigurableApplicationContext ctx= SpringApplication.run(OnlineFoodOrderingSystemV3Application.class, args);
		
		
		CustomerService  customerService = ctx.getBean(CustomerServiceImpl.class);
		log.debug("customerService : {}",customerService);
		
		MenuService  menuService = ctx.getBean(MenuServiceImpl.class);
		log.debug("menuService : {}",menuService);	
		
		MenuTypeService  menuTypeService = ctx.getBean(MenuTypeServiceImpl.class);
		log.debug("menuTypeService : {}",menuTypeService);
		
		CartService  cartService = ctx.getBean(CartServiceImpl.class);
		log.debug("cartService : {}",cartService);
		
		OrderService orderService = ctx.getBean(OrderServiceImpl.class);
		log.debug("orderService : {}",orderService);
		
		RatingService ratingService = ctx.getBean(RatingServiceImpl.class);
		log.debug("ratingService : {}",ratingService);
		
		log.info("END");
		
		
	}

}
