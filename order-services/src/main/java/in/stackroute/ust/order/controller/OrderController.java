package in.stackroute.ust.order.controller;

import in.stackroute.ust.order.domain.Item;
import in.stackroute.ust.order.domain.Order;
import in.stackroute.ust.order.dto.*;
import in.stackroute.ust.order.service.ItemService;
import in.stackroute.ust.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ItemService itemService;
    Item createItem(ItemDto c) {
        return new Item(c.itemId(), c.description(), c.price(), c.quantity(), c.imageUrl());
    }
    public List<Item> createOrderList(OrderDto orderDto) {
        List<Cart> items = orderDto.getListOfItems();
        List<Integer> itemIds = new ArrayList<>();
        List<Integer> itemQuantity = new ArrayList<>();
        List<Item> itemList = new ArrayList<>();
        for (Cart c : items
        ) {
            Item item = createItem(itemService.update(c).get());
            item.setQuantity(c.getQuantity());
            itemList.add(item);
        }
        return itemList;
    }
    public Order createOrder(OrderDtoUpdate orderDto) {
        return new Order(orderDto.getOrderId(), orderDto.getUserId(), orderDto.getItems(), orderDto.getAmount(), orderDto.isStatus());
    }
    public OrderDtoBack createOrderDto(Order order) {
        return new OrderDtoBack(order.getOrderId(), order.getUserId(), order.getItems(), order.getAmount(), order.getStatus());
    }
    @PostMapping()
    public ResponseEntity<OrderDtoBack> Save(@RequestBody OrderDto orderDto) {

        List<Item> items = createOrderList(orderDto);
        Order order = new Order();
        order.setOrderId(orderDto.getOrderId());
        order.setUserId(orderDto.getUserId());
        order.setItems(items);
        order.setAmount(orderDto.getAmount());
        order.setStatus(false);
        orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createOrderDto(order));
    }
    @GetMapping()
    public ResponseEntity<List<OrderDtoBack>> getAll() {
        var res = orderService.getAll().stream().map(this::createOrderDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDtoBack> getById(@PathVariable int orderId) {
        var order = orderService.getByOrderId(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(createOrderDto(order));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDtoBack>> getAllByUserId(@PathVariable int userId) {
        var order = orderService.getAllByUserId(userId).stream().map(this::createOrderDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
    @PutMapping()
    public ResponseEntity<OrderDtoBack> update(@RequestBody OrderDtoUpdate orderDtoUpdate) {
        Order order = createOrder(orderDtoUpdate);
        var orderUpdate = orderService.update(order);
        if (orderDtoUpdate.getAmount() == 0) {
            orderService.deleteById(orderDtoUpdate.getOrderId());
        } else {
            orderService.save(createOrder(orderDtoUpdate));
        }
        return ResponseEntity.status(HttpStatus.OK).body(createOrderDto(orderUpdate));
    }
    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderDtoBack> delete(@PathVariable int orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(createOrderDto(orderService.deleteById(orderId)));
    }
    @PutMapping("/update")
    public ResponseEntity<OrderDtoBack> updateList(@RequestBody OrderDtoUpdate orderDtoUpdate) {
        Order order = orderService.getByOrderId(orderDtoUpdate.getOrderId());
        List<Item> itemsInDto = order.getItems();
        int i = 0;
        List<Item> items = order.getItems();
        for (Item item : items
        ) {
            if (item.getItemId() == itemsInDto.get(i).getItemId()) {
                Cart cart = new Cart(itemsInDto.get(i).getItemId(), itemsInDto.get(i).getQuantity());
                itemService.updateItem(cart);
            } else {
                i++;
            }
        }
        if (orderDtoUpdate.getAmount() == 0) {
            orderService.deleteById(orderDtoUpdate.getOrderId());
        } else {
            orderService.save(createOrder(orderDtoUpdate));
        }
        return ResponseEntity.status(HttpStatus.OK).body(createOrderDto(order));
    }
}
