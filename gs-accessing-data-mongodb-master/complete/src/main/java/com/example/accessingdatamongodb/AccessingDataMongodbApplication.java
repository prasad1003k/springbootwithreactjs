package com.example.accessingdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
		repository.save(new Customer("PrasadaRao", "Kuchipudi"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('PrasadaRao'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("PrasadaRao"));

		System.out.println("Customers found with findByLastName('Kuchipudi'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Kuchipudi")) {
			System.out.println(customer);
		}

	}

}
