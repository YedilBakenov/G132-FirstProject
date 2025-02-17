package kz.first_project.g132.db;

import kz.first_project.g132.model.Car;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBConnector {

    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5432/g132";
    private static String login = "postgres";
    private static String password = "postgres";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Car> getAllCars() {

        List<Car> cars = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars");

            ResultSet resultSet = statement.executeQuery(); // когда мы тянем данные из таблицы

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setCost(resultSet.getInt("cost"));
                car.setModel(resultSet.getString("model"));
                car.setCountry(resultSet.getString("country"));
                car.setEngine(resultSet.getDouble("engine"));

                cars.add(car);
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cars;
    }

    public void addCar(Car car) {

        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO cars " +
                    "(model, engine, cost, country) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, car.getModel());
            statement.setDouble(2, car.getEngine());
            statement.setInt(3, car.getCost());
            statement.setString(4, car.getCountry());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Car getCarById(int id) {

        Car car = new Car();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setCost(resultSet.getInt("cost"));
                car.setEngine(resultSet.getDouble("engine"));
                car.setCountry(resultSet.getString("country"));

                statement.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    public void updateCar(Car car){

        try {

            PreparedStatement statement = connection.prepareStatement("UPDATE cars SET model=?, engine=?, cost=?, " +
                    "country=? WHERE id=?");

            statement.setString(1, car.getModel());
            statement.setDouble(2, car.getEngine());
            statement.setInt(3, car.getCost());
            statement.setString(4, car.getCountry());
            statement.setInt(5, car.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteCar(int id){

        try{

            PreparedStatement statement = connection.prepareStatement("DELETE FROM cars WHERE id=?");
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
