package com.tsk.customersvcs.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tsk.customersvcs.jpa.CustomerRepository;
import com.tsk.customersvcs.model.Customer;

@RestController
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return (List<Customer>) customerRepository.findAll();
		
	}
	@GetMapping("/customers/{id}")
	public Optional<Customer> getCustomer(@PathVariable Integer id){
		return customerRepository.findById(id);
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable Integer id){
		 customerRepository.deleteById(id);
		
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Object> createStudent(@RequestBody Customer customer) {
		Customer cust = customerRepository.save(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cust.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public void initializeFOrSwagger()
	{
		
	}
}
