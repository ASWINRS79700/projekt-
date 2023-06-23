package in.stackroute.ust.item.dto;

import java.util.List;

public class ItemIdsDto {


     private List<Integer> itemIds;
     public  ItemIdsDto(){

     }

    public ItemIdsDto(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }

    public List<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
