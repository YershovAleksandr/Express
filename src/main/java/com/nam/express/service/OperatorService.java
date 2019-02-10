package com.nam.express.service;

import com.nam.express.dao.OperatorTaskDao;
import com.nam.express.model.OperatorTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OperatorService {
    private static Logger log = LoggerFactory.getLogger(OperatorService.class);
    private static OperatorTaskDao operatorTaskDao = new OperatorTaskDao();

    public static List<OperatorTask> viewTask(){
        log.info("View Operator Task");

        return operatorTaskDao.getAll();
    }

    public static void createTaskByOrderId(String id){
        log.info("Operator Create Task id = " + id);

        int intId;

        try {
            intId = Integer.parseInt(id);
        } catch(NumberFormatException e){
            log.error("Illegal task id = " + id);

            return;
        }

        operatorTaskDao.create(intId);
    }
}