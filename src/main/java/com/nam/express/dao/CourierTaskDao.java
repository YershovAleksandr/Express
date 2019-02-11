package com.nam.express.dao;

import com.nam.express.model.CourierTask;
import com.nam.express.util.DataSource2;
import com.nam.express.util.JDBCSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourierTaskDao {
    private static Logger log = LoggerFactory.getLogger(CourierTaskDao.class);

    public List<CourierTask> getAll(){
        log.info("Get All Courier Tasks");

        List<CourierTask> courierTaskList = null;

        try(Connection con = DataSource2.getConnection()) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM courierdb");
            ResultSet rs = pst.executeQuery();

            courierTaskList = new ArrayList<>();

            while(rs.next()){
                CourierTask courierTask = new CourierTask();
                courierTask.setId(rs.getInt("courierdb_id"));
                courierTask.setOrderId(rs.getInt("courierdb_orderid"));
                courierTask.setDescription(rs.getString("courierdb_description"));

                courierTaskList.add(courierTask);
            }
        }catch (Exception e){
            log.error("DB Error", e);
        }

        return courierTaskList;
    }

    public CourierTask get(int id){
        log.info("Get Courier Task id = " + id);

        CourierTask courierTask = null;

        try(Connection con = DataSource2.getConnection()) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM courierdb WHERE courierdb_id = ?");
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                courierTask = new CourierTask();

                courierTask.setId(rs.getInt("courierdb_id"));
                courierTask.setOrderId(rs.getInt("courierdb_orderid"));
                courierTask.setDescription(rs.getString("courierdb_description"));
            }
        }catch (Exception e){
            log.error("DB Error", e);
        }

        return courierTask;
    }

    public void create(CourierTask courierTask){
        log.info("Create Courier Task");

        SimpleJdbcInsert insert = new SimpleJdbcInsert(JDBCSource.getDataSource()).withTableName("courierdb");

        Map<String, Object> param = new HashMap<>();
        param.put("courierdb_orderid", courierTask.getOrderId());
        param.put("courierdb_description", courierTask.getDescription());

        insert.execute(param);
    }

    public int deleteByOrderId(int id){
        log.info("Delete Courier Task");

        int status = -1;

        try(Connection con = DataSource2.getConnection()){
            PreparedStatement pst = con.prepareStatement("DELETE FROM courierdb WHERE courierdb_orderid = ?");

            pst.setInt(1, id);

            status = pst.executeUpdate();
        }catch (Exception e){
            log.error("DB Error", e);
        }

        return status;
    }
}