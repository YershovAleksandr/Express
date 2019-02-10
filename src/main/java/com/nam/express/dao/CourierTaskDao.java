package com.nam.express.dao;

import com.nam.express.model.CourierTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CourierTaskDao {
    private static Logger log = LoggerFactory.getLogger(CourierTaskDao.class);

    private static List<CourierTask> courierTaskList = new ArrayList<>();

    public List<CourierTask> getAll(){

/*        CourierTask courierTask = new CourierTask();
        courierTask.setId(1);
        courierTask.setDescription("Description 1");
        courierTask.setOrderId(1);
        courierTaskList.add(courierTask);

        CourierTask courierTask2 = new CourierTask();
        courierTask2.setId(2);
        courierTask2.setDescription("Description 2");
        courierTask2.setOrderId(3);
        courierTaskList.add(courierTask2);
*/
        return courierTaskList;
    }

    public void create(CourierTask courierTask){
        log.info("Create Courier Task");

        courierTaskList.add(courierTask);
    }

    public void delete(int id){

    }
}