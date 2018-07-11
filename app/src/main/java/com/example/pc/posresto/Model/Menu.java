package com.example.pc.posresto.Model;

public class Menu {

    private int record_id;
    private String name;
    private int price, category_id, count, void_status, delete_status;

    public Menu(int record_id, String name, int price, int category_id, int count, int void_status, int delete_status) {
        this.record_id = record_id;
        this.name = name;
        this.price = price;
        this.category_id = category_id;
        this.count = count;
        this.void_status = void_status;
        this.delete_status = delete_status;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getVoid_status() {
        return void_status;
    }

    public void setVoid_status(int void_status) {
        this.void_status = void_status;
    }

    public int getDelete_status() {
        return delete_status;
    }

    public void setDelete_status(int delete_status) {
        this.delete_status = delete_status;
    }
}
