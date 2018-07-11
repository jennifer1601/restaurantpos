package com.example.pc.posresto.Model;

public class Food {

    private String qty;
    private String name;
    private String foodImage;

    public Food(String qty, String name) {
        this.qty = qty;
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public String getName() {
        return name;
    }

}
