package kz.first_project.g132.controller;

import kz.first_project.g132.component.PrototypeComponent;
import kz.first_project.g132.db.DBConnector;
import kz.first_project.g132.db.DBManager;
import kz.first_project.g132.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/cars/")
public class HomeController {

    private final DBManager dbManager;
    private final DBConnector dbConnector;
    private final ObjectProvider<PrototypeComponent> prototypeComponent;

    @GetMapping(value = "/prototype")
    public String getPrototype(){
        System.out.println(prototypeComponent.getObject().getId());
        return "redirect:/api/cars/";
    }

    @GetMapping(value = "/")
    public String getHomePage(Model model){
        model.addAttribute("mashini", dbConnector.getAllCars());
        return "main";
    }

    @PostMapping(value = "/add-car")
    public String addCar(Car car){
        dbConnector.addCar(car);
        return "redirect:/api/cars/";
    }

    @GetMapping(value = "/add-car")
    public String addCarPage(){
        return "add-car";
    }

    @GetMapping(value = "/car-details/{id}")
    public String carDetailsPage(@PathVariable int id,
                                 Model model){
        model.addAttribute("mashina", dbConnector.getCarById(id));
        return "car-details";
    }

    @PostMapping(value = "/update-car")
    public String updateCar(Car car){
        dbConnector.updateCar(car);
        return "redirect:/api/cars/";
    }

    @PostMapping(value = "/car-delete")
    public String deleteCar(@RequestParam int id){
        dbConnector.deleteCar(id);
        return "redirect:/api/cars/";
    }


}
