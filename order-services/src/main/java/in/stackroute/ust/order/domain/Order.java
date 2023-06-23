package in.stackroute.ust.order.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
   private int orderId;
   private int userId;

    @ElementCollection
    private List<Item> items=new ArrayList<>();
   private int amount;
   private boolean status;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Order(){

    }

    public Order(int orderId, int userId, List<Item> items, int amount, boolean status) {
        this.orderId = orderId;
        this.userId = userId;
        this.items = items;
        this.amount = amount;
        this.status = status;
    }

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}


