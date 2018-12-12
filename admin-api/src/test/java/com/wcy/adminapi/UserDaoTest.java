package com.wcy.adminapi;

import com.wcy.adminapi.dao.CustomerRepository;
import com.wcy.adminapi.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void add(){
        Customer customer = repository.save(new Customer("Alice", "Smith"));
        System.out.println(customer);
    }
}
