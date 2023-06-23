package in.stackroute.ust.order.domain;


import jakarta.persistence.*;

@Embeddable
public class Item {

    private int itemId;
    private String description;
    private int price;
    private int quantity;
    private String imageUrl;


    public Item(){

    }

    public Item(int itemId, String description, int price, int quantity, String imageUrl) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;

    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
