package in.stackroute.ust.order.repository;

import in.stackroute.ust.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {


    List<Order> getAllByUserId(int userId);
}
