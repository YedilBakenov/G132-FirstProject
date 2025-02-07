package kz.first_project.g132.controller;

import kz.first_project.g132.db.DBManager;
import kz.first_project.g132.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.plaf.synth.SynthOptionPaneUI;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String getHomePage(Model model){
        model.addAttribute("mashini", DBManager.getAllCars());
        return "main";
    }

    @PostMapping(value = "/add-car")
    public String addCar(Car car){
        DBManager.addCar(car);
        return "redirect:/";
    }

    @GetMapping(value = "/add-car")
    public String addCarPage(){
        return "add-car";
    }

    @GetMapping(value = "/car-details/{id}")
    public String carDetailsPage(@PathVariable int id,
                                 Model model){
        model.addAttribute("mashina", DBManager.getCarById(id));
        return "car-details";
    }

    @PostMapping(value = "/update-car")
    public String updateCar(Car car){

        DBManager.updateCar(car);
        return "redirect:/";
    }

    @PostMapping(value = "/car-delete")
    public String deleteCar(@RequestParam int id){
        DBManager.deleteCar(id);
        return "redirect:/";
    }


}
