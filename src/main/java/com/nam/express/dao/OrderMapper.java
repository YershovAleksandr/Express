package com.nam.express.dao;

import com.nam.express.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet resultSet, int i) throws SQLException{
        Order order = new Order();

        order.setId(resultSet.getInt("orderdb_id"));
        order.setDescription(resultSet.getString("orderdb_description"));

        return order;
    }
}