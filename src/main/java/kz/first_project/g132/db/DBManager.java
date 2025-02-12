package kz.first_project.g132.db;

import kz.first_project.g132.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
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

    public static void addCar (Car car){
        car.setId(id);
        id++;
        cars.add(car);
    }

    public static Car getCarById(int id) {
        return cars.stream().filter(mashina -> mashina.getId()==id).findFirst().get();
    }

    public static void updateCar(Car car) {

        for(Car obj: cars){
            if(obj.getId()==car.getId()){
                obj.setCost(car.getCost());
                obj.setCountry(car.getCountry());
                obj.setModel(car.getModel());
                obj.setEngine(car.getEngine());
            }
        }

    }

    public static void deleteCar(int id) {
        cars.removeIf(mashina-> mashina.getId()==id);
    }
}
