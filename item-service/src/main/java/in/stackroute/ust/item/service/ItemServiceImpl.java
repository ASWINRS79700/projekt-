package in.stackroute.ust.item.service;

import in.stackroute.ust.item.domain.Item;
import in.stackroute.ust.item.dto.Cart;
import in.stackroute.ust.item.exception.ItemAlreadyExistException;
import in.stackroute.ust.item.exception.ItemNotFoundException;
import in.stackroute.ust.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Override
    public void save(Item c) {
        if(itemRepository.findById(c.getItemId()).isPresent()){
            throw new ItemAlreadyExistException("Given item is already exist ID:"+c.getItemId());
        }
        itemRepository.save(c);
    }
    @Override
    public Item getItemByDescription(String description){

        return itemRepository.getItemByDescription(description).get();
    }

    @Override
    public List<Item> listOfItemsByItemIds(List<Integer> itemIds) {
        return itemRepository.findByItemIdIn(itemIds);
    }

    @Override
    public Item updateItem(Cart cart) {
        Item item=itemRepository.findById(cart.getItemId()).get();
        item.setQuantity(item.getQuantity()-cart.getQuantity());
        itemRepository.save(item);
        return item;

    }

    @Override
    public Item updateItemFromOrder(Cart cart) {
        Item item=itemRepository.getById(cart.getItemId());
        item.setQuantity(item.getQuantity()+cart.getQuantity());
        itemRepository.save(item);
        item=itemRepository.getById(cart.getItemId());
        return item;
    }

    ;
    @Override
    public Item getById(int c) {
        var item=itemRepository.findById(c);
        if(item.isPresent()){
            return item.get();
        }
        else
            throw new ItemNotFoundException("Id is not found ID:"+c);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> delete(int id) {
        itemRepository.deleteById(id);
        return getAll();
    }

    @Override
    public List<Item> update(Item c) {

        itemRepository.save(c);
        return getAll();
    }
}
