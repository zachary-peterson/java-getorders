package com.lambdaschool.com.orders.controllers;

import com.lambdaschool.com.orders.models.Order;
import com.lambdaschool.com.orders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    OrderServices orderServices;

    // http://localhost:2019/orders/order/7
    @GetMapping(value = "/order/{ordid}", produces = "application/json")
    public ResponseEntity<?> findOrderById(@PathVariable long ordid)
    {
        Order orderById = orderServices.findById(ordid);
        return new ResponseEntity<>(orderById, HttpStatus.OK);
    }

}
