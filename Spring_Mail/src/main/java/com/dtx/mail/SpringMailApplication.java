package com.dtx.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.dtx.mail.services.IPurchaseOrder;

@SpringBootApplication

public class SpringMailApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringMailApplication.class, args);
		IPurchaseOrder purchaseOrder = ctx.getBean("purchaseOrder",IPurchaseOrder.class);
		try {
			String status= purchaseOrder.purchase(new String[] {"shirt","Pant"}, new double[] {500.0,600.0}, new String[] {"satyabratnayak6544@gmail.com"});
			System.out.println(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
