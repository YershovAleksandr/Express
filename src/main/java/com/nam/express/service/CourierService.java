package com.nam.express.service;

import com.nam.express.dao.CourierTaskDao;
import com.nam.express.model.CourierTask;
import com.nam.express.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CourierService{
    private static Logger log = LoggerFactory.getLogger(CourierService.class);
    private static CourierTaskDao courierTaskDao = new CourierTaskDao();

    public static List<CourierTask> getAllTask(){
        return courierTaskDao.getAll();
    }

    public static CourierTask getTaskById(String id){
        int intId;

        try {
            intId = Integer.parseInt(id);
        } catch(NumberFormatException e){
            log.error("Illegal id = " + id);

            return null;
        }

        return courierTaskDao.get(intId);
    }

    public static void createTask(CourierTask courierTask){
        courierTaskDao.create(courierTask);
    }

    public static void deleteTaskByOrder(Order order){
        courierTaskDao.deleteByOrderId(order.getId());
    }
}