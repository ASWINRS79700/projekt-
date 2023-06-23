package in.stackroute.ust.order.service;

import in.stackroute.ust.order.dto.Cart;
import in.stackroute.ust.order.dto.ItemDto;
import in.stackroute.ust.order.dto.OrderDto;
import in.stackroute.ust.order.dto.ToItemDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Optional<ItemDto> listOfItemsByItemIds(int itemId);

    Optional<ItemDto> update( Cart cart);
    Optional<ItemDto> updateItem(Cart c);


}
