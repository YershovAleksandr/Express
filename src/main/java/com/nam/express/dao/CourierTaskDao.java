package com.nam.express.dao;

import com.nam.express.dao.mapper.CourierTaskMapper;
import com.nam.express.model.CourierTask;
import com.nam.express.util.DataSource2;
import com.nam.express.util.JDBCSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourierTaskDao {
    private static Logger log = LoggerFactory.getLogger(CourierTaskDao.class);
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCSource.getDataSource());

    public List<CourierTask> getAll(){
        log.info("Get All Courier Tasks");

        return jdbcTemplate.query("SELECT * FROM courierdb", new CourierTaskMapper());
    }

    public CourierTask get(int id){
        log.info("Get Courier Task id = " + id);

        return jdbcTemplate.queryForObject("SELECT * FROM courierdb WHERE courierdb_id = ?", new Object[]{id}, new CourierTaskMapper());
    }

    public void create(CourierTask courierTask){
        log.info("Create Courier Task");

        SimpleJdbcInsert insert = new SimpleJdbcInsert(JDBCSource.getDataSource()).withTableName("courierdb");

        Map<String, Object> param = new HashMap<>();
        param.put("courierdb_orderid", courierTask.getOrderId());
        param.put("courierdb_description", courierTask.getDescription());

        insert.execute(param);
    }

    public void deleteByOrderId(int id){
        log.info("Delete Courier Task");

        jdbcTemplate.update("DELETE FROM courierdb WHERE courierdb_orderid = ?", id);
    }
}