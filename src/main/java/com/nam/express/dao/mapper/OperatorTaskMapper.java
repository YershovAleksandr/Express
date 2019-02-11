package com.nam.express.dao.mapper;

import com.nam.express.model.OperatorTask;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperatorTaskMapper implements RowMapper<OperatorTask> {
    public OperatorTask mapRow(ResultSet resultSet, int i) throws SQLException {
        OperatorTask operatorTask = new OperatorTask();

        operatorTask.setId(resultSet.getInt("operatordb_id"));
        operatorTask.setOrderId(resultSet.getInt("operatordb_orderid"));
        operatorTask.setDate(resultSet.getTimestamp("operatordb_date"));

        return operatorTask;
    }
}