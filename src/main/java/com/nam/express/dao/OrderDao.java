package com.nam.express.dao;

import com.nam.express.model.Order;
import com.nam.express.util.DataSource2;
import com.nam.express.util.JDBCSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class OrderDao {
    private static Logger log = LoggerFactory.getLogger(OrderDao.class);

    public void create(Order order){
        log.info("Create Order");

        SimpleJdbcInsert insert = new SimpleJdbcInsert(JDBCSource.getDataSource()).withTableName("orderdb");

        Map<String, Object> param = new HashMap<>();
        param.put("orderdb_description", order.getDescription());

        insert.execute(param);
    }

    public Order get(int id){
        log.info("Get Order id = " + id);

        Order order = null;

        try(Connection con = DataSource2.getConnection()) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM orderdb WHERE orderdb_id = ?");
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                order = new Order();

                order.setId(rs.getInt("orderdb_id"));
                order.setDescription(rs.getString("orderdb_description"));
            }
        }catch (Exception e){
            log.error("DB Error", e);
        }

        return order;
    }
}