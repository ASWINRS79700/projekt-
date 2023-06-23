package in.stackroute.ust.order.dto;

import java.util.List;

public class ToItemDto {
    List<Integer> itemIds;
    public ToItemDto(){

    }
    public List<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }

    public ToItemDto(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
