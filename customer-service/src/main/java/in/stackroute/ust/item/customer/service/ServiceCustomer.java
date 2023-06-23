package in.stackroute.ust.item.customer.service;

import in.stackroute.ust.item.customer.domain.Customer;

import java.util.List;

public interface ServiceCustomer {
    void save(Customer c);
    Customer searchByEmail(String email);

    Customer getById(int c);
    List<Customer> getAll();
    void delete(int id);
    void update(Customer c);


}
