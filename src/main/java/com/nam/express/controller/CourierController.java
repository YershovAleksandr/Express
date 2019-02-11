package com.nam.express.controller;

import com.nam.express.model.CourierTask;
import com.nam.express.model.Order;
import com.nam.express.service.CourierService;
import com.nam.express.service.OperatorService;
import com.nam.express.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourierController {
    private static Logger log = LoggerFactory.getLogger(CourierController.class);

    @GetMapping("/courier")
    public String courier(Model model){
        log.info("Couriers tasks -> " + CourierService.getAllTask().toString());

        model.addAttribute("taskList", CourierService.getAllTask());

        return "courier";
    }

    @RequestMapping("/postpone")
    public String postpone(@RequestParam(value = "id")String id, Model model){
        log.info("Postpone -> orderId = " + id);

        CourierTask courierTask = CourierService.getTaskById(id);

        if (courierTask != null) {
            Order order = OrderService.getOrderById(courierTask.getOrderId());

            CourierService.deleteTaskByOrder(order);
            OperatorService.createTaskByOrder(order);
        }

        return "redirect:/courier";
    }
}