package kz.first_project.g132.db;

import kz.first_project.g132.model.Car;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static List<Car> cars = new ArrayList<>();

    private static int id = 6;

    static {
        cars.add(new Car(1,"Toyota Camry 80", 3.5,  50000, "Japan"));
        cars.add(new Car(2,"BMW X5", 6.5,  130000, "Germany"));
        cars.add(new Car(3,"Camaz", 10.0,  20000, "USSR"));
        cars.add(new Car(4,"GEELY ATLAS", 2.0,  280000, "CHINA"));
        cars.add(new Car(5,"CHANGAN 55", 1.5,  18000, "CHINA"));
    }

    public static List<Car> getAllCars(){
        return cars;
    }

}
