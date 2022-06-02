package com.exercicio.entities;

import com.exercicio.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> items = new ArrayList<>();


    public Order(Date moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double total () {
        double sum = 0;
        for (OrderItem item : items) {
            sum += item.subtotal();
        }
        return sum;
    }



}
