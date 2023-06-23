package in.stackroute.ust.item.customer.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int id;
    private String email;
    private String name;
public Customer(){

}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
