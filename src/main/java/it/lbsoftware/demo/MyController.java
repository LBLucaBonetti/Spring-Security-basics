package it.lbsoftware.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    private final List<String> users = new ArrayList<>();

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", users);
        return "users";
    }

    // Here we have a vulnerability: we are changing the state of the application with an "unsafe" HTTP method!
    @GetMapping("/submit")
    public String submit(@RequestParam("new-username") String newUsername) {
        users.add(newUsername);
        return "redirect:users";
    }

}
