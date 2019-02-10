package com.nam.express.util;

import com.nam.express.model.CourierTask;
import com.nam.express.model.Order;
import com.nam.express.service.CourierService;
import com.nam.express.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Database {
    private static Logger log = LoggerFactory.getLogger(Database.class);

    public static void init(){
        log.info("Init database");

        initOrderDB();
        initCourierTaskDB();
        initOperatorTaskDB();
    }

    private static void initOrderDB(){
        //TODO Create Order Factory;
        Order order = new Order();
        order.setId(1);
        order.setDescription("Description1");
        OrderService.createOrder(order);

        Order order2 = new Order();
        order2.setId(2);
        order2.setDescription("Description2");
        OrderService.createOrder(order2);

        Order order3 = new Order();
        order3.setId(3);
        order3.setDescription("Description3");
        OrderService.createOrder(order3);
    }

    private static void initCourierTaskDB(){
        //TODO Create CourierTask Factory;

        CourierTask courierTask = new CourierTask();
        courierTask.setId(1);
        courierTask.setDescription("Description 1");
        courierTask.setOrderId(1);
        CourierService.createTask(courierTask);

        CourierTask courierTask2 = new CourierTask();
        courierTask2.setId(2);
        courierTask2.setDescription("Description 2");
        courierTask2.setOrderId(3);
        CourierService.createTask(courierTask2);
    }

    private static void initOperatorTaskDB(){
        //
    }
}