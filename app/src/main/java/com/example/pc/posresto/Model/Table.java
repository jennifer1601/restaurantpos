package com.example.pc.posresto.Model;

public class Table {
    private int record_id;
    private String name;
    private int status, void_status, delete_status;

    public Table(int record_id, String name, int status, int void_status, int delete_status) {
        this.record_id = record_id;
        this.name = name;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
