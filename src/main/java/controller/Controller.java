package controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String index(@RequestParam(value = "id", defaultValue = "42") String id){

        return String.format("<h1> Hello, d</h1>", id);
    }
}
