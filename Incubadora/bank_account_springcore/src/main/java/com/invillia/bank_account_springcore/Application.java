package com.invillia.bank_account_springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext container =
				new AnnotationConfigApplicationContext("com.invillia.bank_account_springcore");

		PersonDAO personDAOImpl = container.getBean("personDAOImpl", PersonDAOImpl.class);

		personDAOImpl.insert(new Person(1L,"Tiago", "478.150.778-62", "57.913.698-X"));
		personDAOImpl.insert(new Person(2L,"João", "123.123.123-123", "23.123.123-X"));

		System.out.println(personDAOImpl.findAll());

		System.out.println(personDAOImpl.findById(2L));
	}

}
