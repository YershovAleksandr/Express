package com.nam.express.util;

import com.nam.express.model.CourierTask;
import com.nam.express.model.Order;
import com.nam.express.service.CourierService;
import com.nam.express.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Statement;

public class Database {
    private static Logger log = LoggerFactory.getLogger(Database.class);

    public static void init(){
        log.info("Init database");

        initOrderTable();
        initCourierTaskTable();
        initOperatorTaskTable();
    }

    private static void initOrderTable(){
        log.info("Init Order Table");

        try(Connection cn = DataSource.getConnection()){
            Statement st = cn.createStatement();

            st.executeUpdate("SET FOREIGN_KEY_CHECKS=0;");
            st.executeUpdate("DROP TABLE orderdb;");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS orderdb(" +
                    "orderdb_id int NOT NULL AUTO_INCREMENT," +
                    "orderdb_description varchar(50) NOT NULL," +
                    "primary key(orderdb_id)" +
                    ") DEFAULT CHARSET=utf8;");

        } catch(Exception e){
            log.error("DB Error", e);
        }

        //TODO Create Order Factory;
        Order order = new Order();
        order.setId(1);
        order.setDescription("Description1");
        OrderService.createOrder(order);

        Order order2 = new Order();
        order2.setId(2);
        order2.setDescription("Description2");
        OrderService.createOrder(order2);

        Order order3 = new Order();
        order3.setId(3);
        order3.setDescription("Description3");
        OrderService.createOrder(order3);
    }

    private static void initCourierTaskTable(){
        log.info("Init Courier Table");

        try(Connection cn = DataSource.getConnection()){
            Statement st = cn.createStatement();

            st.executeUpdate("DROP TABLE courierdb;");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS courierdb(" +
                    "courierdb_id int NOT NULL AUTO_INCREMENT," +
                    "courierdb_orderid int NOT NULL," +
                    "courierdb_description varchar(50) NOT NULL," +
                    "primary key(courierdb_id)," +
                    "foreign key(courierdb_orderid) references orderdb(orderdb_id)" +
                    ") DEFAULT CHARSET=utf8;");

            st.executeUpdate("TRUNCATE TABLE courierdb;");
        } catch(Exception e){
            log.error("DB Error", e);
        }

        //TODO Create CourierTask Factory;

        CourierTask courierTask = new CourierTask();
        courierTask.setId(1);
        courierTask.setDescription("Description 1");
        courierTask.setOrderId(1);
        CourierService.createTask(courierTask);

        CourierTask courierTask2 = new CourierTask();
        courierTask2.setId(2);
        courierTask2.setDescription("Description 2");
        courierTask2.setOrderId(3);
        CourierService.createTask(courierTask2);
    }

    private static void initOperatorTaskTable(){
        log.info("Init Operator Table");

        try(Connection cn = DataSource.getConnection()){
            Statement st = cn.createStatement();

            st.executeUpdate("DROP TABLE operatordb;");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS operatordb(" +
                    "operatordb_id int NOT NULL AUTO_INCREMENT," +
                    "operatordb_orderid int NOT NULL," +
                    "operatordb_date timestamp NOT NULL," +
                    "primary key(operatordb_id)," +
                    "foreign key(operatordb_orderid) references orderdb(orderdb_id)" +
                    ") DEFAULT CHARSET=utf8;");

            st.executeUpdate("TRUNCATE TABLE operatordb;");
            st.executeUpdate("SET FOREIGN_KEY_CHECKS=1;");
        } catch(Exception e){
            log.error("DB Error", e);
        }
    }
}