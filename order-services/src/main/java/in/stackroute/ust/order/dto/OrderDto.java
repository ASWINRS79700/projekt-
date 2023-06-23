package in.stackroute.ust.order.dto;

import java.util.List;

public class OrderDto {
    int orderId;
    int userId;
    List<Cart> listOfItems;
    int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public OrderDto(){}

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Cart> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<Cart> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public OrderDto(int orderId, int userId, List<Cart> listOfItems,int amount) {
        this.orderId = orderId;
        this.userId = userId;
        this.listOfItems = listOfItems;
        this.amount=amount;
    }
}
