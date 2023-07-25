package in.stackroute.ust.item.controller;

import in.stackroute.ust.item.domain.Item;
import in.stackroute.ust.item.dto.Cart;
import in.stackroute.ust.item.dto.ItemDto;
import in.stackroute.ust.item.dto.ItemIdsDto;
import in.stackroute.ust.item.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin

@RestController
@RequestMapping("/api/v1/items")

public class ItemContoller {
    @Autowired
    ItemService itemService;
    private Logger logger = LoggerFactory.getLogger(ItemContoller.class);

    ItemDto createDto(Item c){
        ItemDto itemDto=new ItemDto(c.getItemId(),c.getDescription(),c.getPrice(),c.getQuantity(),c.getImageUrl());
        return itemDto;
    }
    Item createCustomer(ItemDto c)
    {
        Item item=new Item(c.itemId(),c.description(),c.price(),c.quantity(),c.imageUrl());
        return item;
    }

    @PostMapping("")
    public ResponseEntity<?> Save( @RequestBody ItemDto cc){
        var c=createCustomer(cc);
        logger.info("Item Entity: {}", c);
        itemService.save(c);
        logger.info("Item added:{}", c);

        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }
    @PostMapping("/update")
    public ResponseEntity<?>updateItem(@RequestBody Cart cart){
        Item remaining=itemService.updateItem(cart);
        return ResponseEntity.status(HttpStatus.OK).body(remaining);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<ItemDto> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(createDto(itemService.getById(id)));
    }
    @GetMapping("/description/{description}")
    public  ResponseEntity<ItemDto> getBydescription(@PathVariable String description){
        return ResponseEntity.status(HttpStatus.FOUND).body(createDto(itemService.getItemByDescription(description)));
    }
    @GetMapping()
    public ResponseEntity<List<ItemDto>> getAll(){
        List<ItemDto> ll=itemService.getAll().stream().map(this::createDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(ll);
    }
    @GetMapping("/itemids")
    public ResponseEntity<List<ItemDto>>getItemsByIds(@RequestBody ItemIdsDto itemIdsDto){
        var res=itemService.listOfItemsByItemIds(itemIdsDto.getItemIds()).stream().map(this::createDto).toList();
        return ResponseEntity.status(HttpStatus.FOUND).body(res);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<ItemDto>> delete(@PathVariable int id){
        List<ItemDto> ll=itemService.delete(id).stream().map(this::createDto).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(ll);
    }
    @PutMapping("")
    public  ResponseEntity<List<ItemDto>>update(@RequestBody ItemDto cc){
        var c=createCustomer(cc);
        List<ItemDto> ll=itemService.update(c).stream().map(this::createDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(ll);
    }
    @PostMapping("/updateitem")
    public ResponseEntity<Item>updateItemFromOrder(@RequestBody Cart cart){

        return ResponseEntity.status(HttpStatus.OK).body(itemService.updateItemFromOrder(cart));
    }

}
