package com.lambdaschool.com.orders.controllers;

import com.lambdaschool.com.orders.models.Customer;
import com.lambdaschool.com.orders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{

    @Autowired
    CustomerServices customerServices;

    // http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomersOrders()
    {
        List<Customer> allCustomers = customerServices.findAllCustomersOrders();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    // http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{custid}", produces = "application/json")
    public ResponseEntity<?> listCustomerById(@PathVariable long custid)
    {
        Customer customerById = customerServices.findCustomerById(custid);
        return new ResponseEntity<>(customerById, HttpStatus.OK);
    }

    // http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{custname}", produces = "application/json")
    public ResponseEntity<?> findCustomerNameLike(@PathVariable String custname)
    {
        List<Customer> customerNameLike = customerServices.findByNameLike(custname);
        return new ResponseEntity<>(customerNameLike, HttpStatus.OK);
    }
}
