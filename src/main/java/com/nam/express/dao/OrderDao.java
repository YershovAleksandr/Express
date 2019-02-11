package com.nam.express.dao;

import com.nam.express.model.Order;
import com.nam.express.util.JDBCSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.Map;

public class OrderDao {
    private static Logger log = LoggerFactory.getLogger(OrderDao.class);
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCSource.getDataSource());

    public void create(Order order){
        log.info("Create Order");

        SimpleJdbcInsert insert = new SimpleJdbcInsert(JDBCSource.getDataSource()).withTableName("orderdb");

        Map<String, Object> param = new HashMap<>();
        param.put("orderdb_description", order.getDescription());

        insert.execute(param);
    }

    public Order get(int id){
        log.info("Get Order id = " + id);

        return jdbcTemplate.queryForObject("SELECT * FROM orderdb WHERE orderdb_id = ?", new Object[]{id}, new OrderMapper());
    }
}