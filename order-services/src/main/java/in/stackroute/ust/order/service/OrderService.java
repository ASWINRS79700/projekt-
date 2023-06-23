package in.stackroute.ust.order.service;

import in.stackroute.ust.order.domain.Order;
import in.stackroute.ust.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    Order save(Order orderDto);
    List<Order> getAll();
    Order getByOrderId(int orderId);
//    List<Order> getAllByUserId(int userId);
    Order deleteById(int orderId);
    Order update(Order order);

}
