package in.stackroute.ust.item.customer.repository;

import in.stackroute.ust.item.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> searchByEmail(String email);
}
