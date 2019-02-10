package com.nam.express.controller;

import com.nam.express.service.CourierService;
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
    public String home(Model model){
        log.info("Courier");

        CourierService.ViewOrders();

        return "courier";
    }

    @RequestMapping("/courier")
    public String postpone(@RequestParam(value = "id")String id, Model model){
        log.info("Postpone orderId = " + id);

        CourierService.PostponDelivery(id);

        return "redirect:/courier";
    }
}
