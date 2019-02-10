package com.nam.express.dao;

import com.nam.express.model.OperatorTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OperatorTaskDao {
    private Logger log = LoggerFactory.getLogger(OperatorTaskDao.class);

    public List<OperatorTask> getAll(){
        log.info("Get all Operator Task");

        return null;
    }

    public void create(int id){
        log.info("Create new Operator Task");

        //TODO insert into OperatorTask value(?, ?) id, date;


    }
}