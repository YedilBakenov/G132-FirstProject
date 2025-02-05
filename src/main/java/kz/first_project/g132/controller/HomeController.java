package kz.first_project.g132.controller;

import kz.first_project.g132.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String getHomePage(Model model){
        model.addAttribute("mashini", DBManager.getAllCars());
        return "main";
    }

}
