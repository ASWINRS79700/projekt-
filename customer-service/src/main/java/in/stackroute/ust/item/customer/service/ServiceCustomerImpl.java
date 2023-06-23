package in.stackroute.ust.item.customer.service;

import in.stackroute.ust.item.customer.domain.Customer;
import in.stackroute.ust.item.customer.exception.CustomerAlreadyExixt;
import in.stackroute.ust.item.customer.exception.CustomerNotFound;
import in.stackroute.ust.item.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCustomerImpl implements ServiceCustomer{

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void save(Customer c) {
        if(customerRepository.findById(c.getId()).isPresent()){
            throw new CustomerAlreadyExixt(customerRepository.findById(c.getId()).get().getName()+" Customer already exist");
        }
        customerRepository.save(c);
    }

    @Override
    public Customer getById(int c) {
        if(customerRepository.findById(c).isEmpty()){
            throw new CustomerNotFound("id "+c+" is not linked to any Customer");
        }

        return customerRepository.findById(c).get();
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }


    @Override
    public void delete(int id) {
        if(customerRepository.findById(id).isEmpty()){
            throw new CustomerNotFound("id "+id+"  is not linked to any Customer");
        }
        customerRepository.deleteById(id);
    }

    @Override
    public void update(Customer c) {
      customerRepository.save(c);
    }
    @Override
    public Customer searchByEmail(String email){
        if(customerRepository.searchByEmail(email).isEmpty()){
            throw new CustomerNotFound("Email is not linked to any Customer");
        }
        return customerRepository.searchByEmail(email).get();
    }

}
