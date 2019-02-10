package com.nam.express.service;

import com.nam.express.dao.CourierTaskDao;
import com.nam.express.model.CourierTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CourierService{
    private static Logger log = LoggerFactory.getLogger(CourierService.class);
    private static CourierTaskDao courierTaskDao = new CourierTaskDao();

    public static List<CourierTask> getAllTask(){
        log.info("View Courier Task");

        return courierTaskDao.getAll();
    }

    public static void createTask(CourierTask courierTask){


        courierTaskDao.create(courierTask);
    }

    public static void deleteTaskByOrderId(String id){
        log.info("Postpone Courier Task id = " + id);

        int intId;

        try {
            intId = Integer.parseInt(id);
        } catch(NumberFormatException e){
            log.error("Illegal task id = " + id);

            return;
        }

        courierTaskDao.delete(intId);
    }
}