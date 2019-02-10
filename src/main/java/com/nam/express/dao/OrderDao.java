package com.nam.express.dao;

import com.nam.express.model.Order;
import com.nam.express.util.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao {
    private static Logger log = LoggerFactory.getLogger(OrderDao.class);

    public int create(Order order){
        log.info("Create Order");

        int status = -1;

        try(Connection con = DataSource.getConnection()){
            PreparedStatement pst = con.prepareStatement("INSERT INTO orderdb(orderdb_description) VALUES (?)");

            pst.setString(1, order.getDescription());

            status = pst.executeUpdate();
        }catch (Exception e){
            log.error("DB Error", e);
        }

        return status;
    }

    public Order get(int id){
        log.info("Get Order id = " + id);

        Order order = null;

        try(Connection con = DataSource.getConnection()) {
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