package in.stackroute.ust.item.customer.controller;

import in.stackroute.ust.item.customer.domain.Customer;
import in.stackroute.ust.item.customer.dto.CustomerDto;
import in.stackroute.ust.item.customer.service.ServiceCustomerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerContoller {
    @Autowired
    ServiceCustomerImpl serviceCustomer;
    private Logger logger = LoggerFactory.getLogger(CustomerContoller.class);

    CustomerDto createDto(Customer c){
        CustomerDto customerDto=new CustomerDto(c.getId(), c.getName(), c.getEmail());
        return customerDto;
    }
    Customer createCustomer(CustomerDto c)
    {
        Customer customer=new Customer(c.id(), c.name(), c.email());
        return customer;
    }

    @PostMapping("")
    public ResponseEntity<?> Save(@Valid @RequestBody CustomerDto cc){
        var c=createCustomer(cc);
        logger.info("Customer Entity: {}", c);
        serviceCustomer.save(c);
        logger.info("Customer added:{}", c);

        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(createDto(serviceCustomer.getById(id)));
    }
    @GetMapping("/email/{email}")
    public  ResponseEntity<?> getByEmail(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.FOUND).body(createDto(serviceCustomer.searchByEmail(email)));
    }
    @GetMapping("")
    public ResponseEntity<List<CustomerDto>> getAll(){
        List<CustomerDto> ll=serviceCustomer.getAll().stream().map(customer -> createDto(customer)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.FOUND).body(ll);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        serviceCustomer.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("")
    public  ResponseEntity<?>update(@Valid @RequestBody CustomerDto cc){
        var c=createCustomer(cc);
        serviceCustomer.update(c);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
