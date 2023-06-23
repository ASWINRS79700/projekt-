package in.stackroute.ust.order.service;

import in.stackroute.ust.order.dto.Cart;
import in.stackroute.ust.order.dto.ItemDto;
import in.stackroute.ust.order.dto.ToItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    RestTemplate restTemplate;
    public static String url="http://localhost:8080/api/v1/items/{itemId}";
    public static String url1="http://localhost:8080/api/v1/items/update";
    public static String url2="http://localhost:8080/api/v1/items/updateitem";

    @Override
    public Optional<ItemDto> listOfItemsByItemIds(int itemId) {
        try {
            final var res=restTemplate.getForEntity(url,ItemDto.class,itemId);
//            if(res.getStatusCode().is2xxSuccessful()){
//                return Optional.ofNullable(res.getBody());
//            }
//            return Optional.empty();
            return Optional.ofNullable(res.getBody());
        }
        catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ItemDto> update(Cart cart) {
        try {
            final var res=restTemplate.postForEntity(url1,cart,ItemDto.class);
//            if(res.getStatusCode().is2xxSuccessful()){
//                return Optional.ofNullable(res.getBody());
//            }
//            return Optional.empty();
            return Optional.ofNullable(res.getBody());
        }
        catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ItemDto> updateItem(Cart c) {
        try {
            final var res=restTemplate.postForEntity(url2,c,ItemDto.class);
//            if(res.getStatusCode().is2xxSuccessful()){
//                return Optional.ofNullable(res.getBody());
//            }
//            return Optional.empty();
            return Optional.ofNullable(res.getBody());
        }
        catch (Exception e){
            return Optional.empty();
        }
    }


}
