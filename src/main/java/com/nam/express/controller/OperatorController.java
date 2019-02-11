package com.nam.express.controller;

import com.nam.express.service.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperatorController {
    private static Logger log = LoggerFactory.getLogger(OperatorController.class);

    @GetMapping("/operator")
    public String operator(Model model){
        log.info("Operator tasks -> " + OperatorService.getAllTask().toString());

        model.addAttribute("taskList", OperatorService.getAllTask());

        return "operator";
    }

    @RequestMapping("/search")
    public String search(@RequestParam(value = "id")String id, Model model){
        log.info("Search Order Id = " + id);

        model.addAttribute("task", OperatorService.getTaskByOrderId(id));
        model.addAttribute("id", id);

        return "operatorsearch";
    }
}