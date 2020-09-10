package com.lambdaschool.com.orders.services;

import com.lambdaschool.com.orders.models.Order;
import com.lambdaschool.com.orders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderServicesImpl implements OrderServices
{
    @Autowired
    private OrdersRepository orderRepos;

    @Override
    public Order save(Order order)
    {
        return orderRepos.save(order);
    }

    @Override
    public Order findById(long ordid)
    {
        return orderRepos.findById(ordid)
        .orElseThrow(() -> new EntityNotFoundException("The Order with ID: " + ordid + " could not be found, please try again!"));
    }
}
