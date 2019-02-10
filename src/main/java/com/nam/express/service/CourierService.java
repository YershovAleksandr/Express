package com.nam.express.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourierService{
    private static Logger log = LoggerFactory.getLogger(CourierService.class);

    public static void ViewOrders(){
        log.info("Orders");
    }

    public static void PostponDelivery(String id){
        log.info("Postpone orderId = " + id);
    }
}
