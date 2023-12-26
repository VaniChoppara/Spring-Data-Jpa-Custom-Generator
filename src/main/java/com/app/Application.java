package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.app.entity.OrderDetails;
import com.app.repo.OrderDetailsRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		OrderDetailsRepository orderDetailsRepository = context.getBean(OrderDetailsRepository.class);
		OrderDetails od=new OrderDetails();
		od.setOrderName("Iphone 15 por");
		od.setOrderPrice(120000.20);
		od.setOrderQty(1);
		orderDetailsRepository.save(od);
	}

}
