package com.example.demo.hotels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class hotels {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hotelname;
    private Long price;
    private Long inventory;

    public hotels() {
        super();
    }

    public hotels(Long id, String hotelname, Long price, Long inventory) {
        super();
        this.id = id;
        this.hotelname = hotelname;
        this.price = price;
        this.inventory=inventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return hotelname;
    }

    public void setName(String hotelname) {
        this.hotelname = hotelname;
    }

    public Long getprice() {
        return price;
    }

    public void setprice(Long price) {
        this.price = price;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

}
