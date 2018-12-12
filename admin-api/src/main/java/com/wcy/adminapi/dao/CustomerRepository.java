package com.wcy.adminapi.dao;

import com.wcy.adminapi.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

}