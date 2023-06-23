package in.stackroute.ust.order.service;

import in.stackroute.ust.order.domain.Order;
import in.stackroute.ust.order.dto.OrderDto;
import in.stackroute.ust.order.exception.OrderNotFoundExceprtion;
import in.stackroute.ust.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{


    @Autowired
    OrderRepository orderRepository;


    @Override
    public Order save(Order orderDto) {

        return orderRepository.save(orderDto);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getByOrderId(int orderId){
        var order=orderRepository.findById(orderId);
        if(order.isPresent()){

            return order.get();
        }
        else{
            throw new OrderNotFoundExceprtion("Order not found: "+orderId);
        }
    }

//    @Override
//    public List<Order> getAllByUserId(int userId) {
//        return orderRepository.getAllByUserId(userId);
//    }

    @Override
    public Order deleteById(int orderId) {
        var order=orderRepository.findById(orderId);
        orderRepository.deleteById(orderId);
        return order.get();
    }

    @Override
    public Order update(Order order) {
        orderRepository.save(order);
        return orderRepository.findById(order.getOrderId()).get();
    }


}
