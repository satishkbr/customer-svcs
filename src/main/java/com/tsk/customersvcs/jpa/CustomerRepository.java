package com.tsk.customersvcs.jpa;
import org.springframework.data.repository.CrudRepository;

import com.tsk.customersvcs.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{

}
