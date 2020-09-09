package com.lambdaschool.com.orders.services;

import com.lambdaschool.com.orders.models.Customer;
import com.lambdaschool.com.orders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServicesImpl implements CustomerServices
{
    @Autowired
    private CustomersRepository customRepos;

    @Override
    public Customer save(Customer customer)
    {
        return customRepos.save(customer);
    }

    @Override
    public List<Customer> findAllCustomersOrders()
    {
        List<Customer> allCustomers = new ArrayList<>();
        customRepos.findAll().iterator().forEachRemaining(allCustomers::add);
        return allCustomers;
    }

    @Override
    public Customer findCustomerById(long custid)
    {
        return customRepos.findById(custid)
        .orElseThrow(() -> new EntityNotFoundException("Customer with ID: " + custid + " could not be found, please try again!"));
    }

    @Override
    public List<Customer> findByNameLike(String custname)
    {
        List<Customer> namesLike =  customRepos.findByCustnameContainingIgnoreCase(custname);
        return  namesLike;
    }
}
