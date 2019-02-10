package com.nam.express.service;

import com.nam.express.dao.OrderDao;
import com.nam.express.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {
    private static Logger log = LoggerFactory.getLogger(OrderService.class);
    private static OrderDao orderDao = new OrderDao();

    public static void createOrder(Order order){
        log.info("Create Order");

        orderDao.create(order);
    }

    public static Order getOrderById(String id){
        log.info("Get Order id = " + id);

        int intId;

        try {
            intId = Integer.parseInt(id);
        } catch(NumberFormatException e){
            log.error("Illegal order id = " + id);

            return null;
        }

        return orderDao.get(intId);
    }
}