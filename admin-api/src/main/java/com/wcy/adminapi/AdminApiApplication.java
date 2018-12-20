package com.wcy.adminapi;

import com.wcy.adminapi.dao.CustomerRepository;
import com.wcy.adminapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminApiApplication implements CommandLineRunner {
    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AdminApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Customer customer = repository.save(new Customer("Alice", "Smith"));
        //System.out.println(customer);
    }
}
