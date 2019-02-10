package com.nam.express.model;

public class Order {
    private int id;
    private String Description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Order {" +
                "id=" + id +
                ", Description='" + Description + '\'' +
                '}';
    }
}