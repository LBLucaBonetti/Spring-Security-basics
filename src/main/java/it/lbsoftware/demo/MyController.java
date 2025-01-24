package it.lbsoftware.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @GetMapping
    public String index(@RequestParam String message, Model model) {
        // 1. Try calling http://localhost:8080/?message=Pleased%20to%20meet%20you!
        // 2. Try calling http://localhost:8080/?message=This%20is%20a%20totally%20legit%20message%3C/p%3E%3Cscript%3Ealert(localStorage.getItem(%27secret%27))%3C/script%3E%3Cp%3E
        model.addAttribute("message", message);
        return "index";
    }

}
