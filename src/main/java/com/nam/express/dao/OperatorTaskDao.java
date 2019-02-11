package com.nam.express.dao;

import com.nam.express.model.OperatorTask;
import com.nam.express.util.DataSource2;
import com.nam.express.util.JDBCSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatorTaskDao {
    private Logger log = LoggerFactory.getLogger(OperatorTaskDao.class);

    public List<OperatorTask> getAll(){
        log.info("Get all Operator Task");

        List<OperatorTask> operatorTaskList = null;

        try(Connection con = DataSource2.getConnection()) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM operatordb");
            ResultSet rs = pst.executeQuery();

            operatorTaskList = new ArrayList<>();

            while(rs.next()){
                OperatorTask operatorTask = new OperatorTask();
                operatorTask.setId(rs.getInt("operatordb_id"));
                operatorTask.setOrderId(rs.getInt("operatordb_orderid"));
                operatorTask.setDate(rs.getTimestamp("operatordb_date"));

                operatorTaskList.add(operatorTask);
            }
        }catch (Exception e){
            log.error("DB Error", e);
        }

        return operatorTaskList;
    }

    public List<OperatorTask> get(String query){
        log.info("Get Task Operator Query = " + query);


        return null;
    }

    public void createByOrderId(int id){
        log.info("Create Operator Task");

        SimpleJdbcInsert insert = new SimpleJdbcInsert(JDBCSource.getDataSource()).withTableName("operatordb");

        Map<String, Object> param = new HashMap<>();
        param.put("operatordb_orderid", id);
        param.put("operatordb_date", new Timestamp(System.currentTimeMillis()));

        insert.execute(param);
    }
}