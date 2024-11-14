package com.bootcamp.bankapp.customer;

import com.bootcamp.bankapp.customer.repository.CustomerRepository;
import com.bootcamp.bankapp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CustomerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}



}
