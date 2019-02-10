package com.nam.express.service;

import com.nam.express.dao.OperatorTaskDao;
import com.nam.express.model.OperatorTask;
import com.nam.express.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OperatorService {
    private static Logger log = LoggerFactory.getLogger(OperatorService.class);
    private static OperatorTaskDao operatorTaskDao = new OperatorTaskDao();

    public static List<OperatorTask> getAllTask(){
        return operatorTaskDao.getAll();
    }

    public static void createTaskByOrder(Order order){
        log.info("Operator create task -> order " + order);

        operatorTaskDao.createByOrderId(order.getId());
    }
}