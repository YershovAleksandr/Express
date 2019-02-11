package com.nam.express.dao.mapper;

import com.nam.express.model.CourierTask;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourierTaskMapper implements RowMapper<CourierTask> {
    public CourierTask mapRow(ResultSet resultSet, int i) throws SQLException {
        CourierTask courierTask = new CourierTask();

        courierTask.setId(resultSet.getInt("courierdb_id"));
        courierTask.setOrderId(resultSet.getInt("courierdb_orderid"));
        courierTask.setDescription(resultSet.getString("courierdb_description"));

        return courierTask;
    }
}