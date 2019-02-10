package com.nam.express.controller;

import com.nam.express.service.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperatorController {
    private static Logger log = LoggerFactory.getLogger(OperatorController.class);

    @GetMapping("/operator")
    public String home(Model model){
        log.info("Operator");

        OperatorService.ViewOrders();

        return "operator";
    }
}
