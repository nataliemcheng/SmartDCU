package com.example.grpee417.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.grpee417.Customer.Customer;
import com.example.grpee417.repository.CustomerRepository;

import com.example.grpee417.Customer2.Customer2;
import com.example.grpee417.repository2.CustomerRepository2;

@CrossOrigin
@RestController
public class controller {

	 	@Autowired
	    CustomerRepository customerRepository;
	 	
	 	@Autowired
	    CustomerRepository2 customerRepository2;

	    @CrossOrigin
	    @PostMapping("/submitCustomer")
	    public void submitCustomer(@RequestBody Customer customer) {
	        try {
	            // Save customer data to the database using the repository
	            customerRepository.save(customer);
	            System.out.println("Customer data saved to database: " + customer);
	        } catch (Exception e) {
	            System.err.println("Error saving customer data to database: " + e.getMessage());
	        }
	    }
	    
	    @CrossOrigin
	    @PostMapping("/submitCustomer2")
	    public void submitCustomer(@RequestBody Customer2 customer2) {
	        try {
	            // Save customer data to the database using the repository
	            customerRepository2.save(customer2);
	            System.out.println("Customer data saved to database: " + customer2);
	        } catch (Exception e) {
	            System.err.println("Error saving customer data to database: " + e.getMessage());
	        }
	    }
}
