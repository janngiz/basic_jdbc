package com.anurag.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String getWelcomePage(Model model) {
       // model.addAttribute("message", "Welcome to our website!");
        return "welcome"; // Thymeleaf template name without the .html extension
    }

    @GetMapping("/normal-page")
    public String getNormalPage() {
        return "normal-page"; // The name of a normal HTML page (e.g., normal-page.html) in src/main/resources/static
    }
}
