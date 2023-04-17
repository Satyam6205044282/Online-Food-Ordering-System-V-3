package com.satyamcompany.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.satyamcompany.app.service.CustomerService;
import com.satyamcompany.app.service.CustomerServiceImpl;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@SpringBootApplication
public class OnlineFoodOrderingSystemV3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(OnlineFoodOrderingSystemV3Application.class, args);
		
		
		CustomerService  service= ctx.getBean(CustomerServiceImpl.class);
		log.debug("service : {}",service);
		
	}

}
