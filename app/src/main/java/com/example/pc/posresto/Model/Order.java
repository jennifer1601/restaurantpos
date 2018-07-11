package com.example.pc.posresto.Model;

public class Order {
    private int record_id, table_id, void_status, delete_status;

    public Order(int record_id, int table_id, int void_status, int delete_status) {
        this.record_id = record_id;
        this.table_id = table_id;
        this.void_status = void_status;
        this.delete_status = delete_status;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
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
