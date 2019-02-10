package com.nam.express.model;

import java.util.Date;

public class OperatorTask {
    private int id;
    private int orderId;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OperatorTask {" +
                "id=" + id +
                ", orderId=" + orderId +
                ", date=" + date +
                '}';
    }
}