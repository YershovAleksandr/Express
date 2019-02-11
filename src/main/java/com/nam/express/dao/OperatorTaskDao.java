package com.nam.express.dao;

import com.nam.express.dao.mapper.OperatorTaskMapper;
import com.nam.express.model.OperatorTask;
import com.nam.express.util.JDBCSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatorTaskDao {
    private Logger log = LoggerFactory.getLogger(OperatorTaskDao.class);
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCSource.getDataSource());

    public List<OperatorTask> getAll(){
        log.info("Get all Operator Task");

        return jdbcTemplate.query("SELECT * FROM operatordb", new OperatorTaskMapper());
    }

    public OperatorTask get(int id){
        log.info("Get Operator Task id = " + id);

        OperatorTask operatorTask = null;
        try {
            operatorTask = jdbcTemplate.queryForObject("SELECT * FROM operatordb where operatordb_orderid = ?", new Object[]{id}, new OperatorTaskMapper());
        }catch (Exception e){
            log.warn("Not Found");
        }

        return  operatorTask;
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