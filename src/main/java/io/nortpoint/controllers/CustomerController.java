package io.nortpoint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.nortpoint.beans.Customer;
import io.nortpoint.store.CustomersFakeRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private final CustomersFakeRepository customersRepository;

  @Autowired
  public CustomerController(CustomersFakeRepository repository) {
    this.customersRepository = repository;
  }

  private final CustomerResourceAssembler customerResourceAssembler;
  (...)
  @Autowired
  public CustomerController(CustomerResourceAssembler customerResourceAssembler, CustomersFakeRepository repository) {
    this.customerResourceAssembler = customerResourceAssembler;
    this.customersRepository = repository;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  ResponseEntity<Resource<Customer>> getCustomer(@PathVariable("id") Integer id) {
    Customer customer = customersRepository.findById(id);
    if (customer == null) {
        throw new EntityNotFoundException("Customer not found - id: " + id);
    }
    Resource<Customer> resource = customerResourceAssembler.toResource(customer);
    return ResponseEntity.ok(resource);
  }

}
mvn clean spring-boot:run and test it:

> curl -X GET -H "Content-type: application/json" http://localhost:8080/customers/1
{
  "id" : 1,
  "fullName" : "Edsger Dijkstra",
  "phone" : "11-111-111"
}
