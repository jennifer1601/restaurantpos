package com.example.pc.posresto.Model;

public class OrderDetail {
    private int table,order_id, menu_id, qty, void_status, delete_status, price;
    private String note, name;

    public OrderDetail(int table, int order_id, int menu_id, int qty, int void_status, int delete_status, int price, String note, String name) {
        this.table = table;
        this.order_id = order_id;
        this.menu_id = menu_id;
        this.qty = qty;
        this.void_status = void_status;
        this.delete_status = delete_status;
        this.price = price;
        this.note = note;
        this.name = name;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
