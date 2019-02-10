package com.nam.express.model;

public class CourierTask {
    private int id;
    private int orderId;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourierTask {" +
                "id=" + id +
                ", orderId=" + orderId +
                ", description='" + description + '\'' +
                '}';
    }
}