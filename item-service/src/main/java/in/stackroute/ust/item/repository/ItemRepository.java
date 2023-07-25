package in.stackroute.ust.item.repository;

import in.stackroute.ust.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> getItemByDescription(String description);
    List<Item> findByItemIdIn(List<Integer> itemIds);

}
