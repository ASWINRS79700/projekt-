package in.stackroute.ust.item.service;

import in.stackroute.ust.item.domain.Item;
import in.stackroute.ust.item.dto.Cart;

import java.util.List;

public interface ItemService {
    void save(Item c);
    Item getById(int c);
    List<Item> getAll();
    List<Item> delete(int id);
    List<Item> update(Item c);
     Item getItemByDescription(String description);
    List<Item> listOfItemsByItemIds(List<Integer> itemIds);
    Item updateItem(Cart cart);
    Item updateItemFromOrder(Cart cart);



}
