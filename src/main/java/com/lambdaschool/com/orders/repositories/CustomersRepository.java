package com.lambdaschool.com.orders.repositories;

import com.lambdaschool.com.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer, Long>
{
}
