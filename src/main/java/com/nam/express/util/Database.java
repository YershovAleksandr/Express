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


        Order order = new Order();
        order.setDescription("Description 1");
        OrderService.createOrder(order);

        Order order2 = new Order();
        order2.setDescription("Description 2");
        OrderService.createOrder(order2);

        Order order3 = new Order();
        order3.setDescription("Description 3");
        OrderService.createOrder(order3);

        Order order4 = new Order();
        order4.setDescription("Description 4");
        OrderService.createOrder(order4);

        Order order5 = new Order();
        order5.setDescription("Description 5");
        OrderService.createOrder(order5);

        CourierTask courierTask = new CourierTask();
        courierTask.setDescription("Description 1");
        courierTask.setOrderId(1);
        CourierService.createTask(courierTask);

        CourierTask courierTask2 = new CourierTask();
        courierTask2.setDescription("Description 2");
        courierTask2.setOrderId(2);
        CourierService.createTask(courierTask2);

        CourierTask courierTask3 = new CourierTask();
        courierTask3.setDescription("Description 3");
        courierTask3.setOrderId(3);
        CourierService.createTask(courierTask3);

        CourierTask courierTask4 = new CourierTask();
        courierTask4.setDescription("Description 4");
        courierTask4.setOrderId(4);
        CourierService.createTask(courierTask4);

        CourierTask courierTask5 = new CourierTask();
        courierTask5.setDescription("Description 5");
        courierTask5.setOrderId(5);
        CourierService.createTask(courierTask5);
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