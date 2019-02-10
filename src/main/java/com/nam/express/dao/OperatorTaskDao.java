package com.nam.express.dao;

import com.nam.express.model.OperatorTask;
import com.nam.express.util.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OperatorTaskDao {
    private Logger log = LoggerFactory.getLogger(OperatorTaskDao.class);

    public List<OperatorTask> getAll(){
        log.info("Get all Operator Task");

        List<OperatorTask> operatorTaskList = null;

        try(Connection con = DataSource.getConnection()) {
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

    public int createByOrderId(int id){
        log.info("Create Operator Task");

        int status = -1;

        try(Connection con = DataSource.getConnection()){
            PreparedStatement pst = con.prepareStatement("INSERT INTO operatordb(operatordb_orderid, operatordb_date) VALUES (?, ?)");

            pst.setInt(1, id);
            pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));

            status = pst.executeUpdate();
        }catch (Exception e){
            log.error("DB Error", e);
        }

        return status;
    }
}