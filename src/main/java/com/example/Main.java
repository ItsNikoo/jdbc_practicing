package com.example;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sys"; // Адрес базы данных
        String user = "root"; // Имя пользователя
        String password = "Nik09012006"; // Пароль

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Car> cars = new ArrayList<>();

        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Все работает!");

            //statement = connection.createStatement();
            String query = "SELECT * FROM cars";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery(query);

            String request = "INSERT INTO cars (brand, model, release_year) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1,"Audi");
            preparedStatement.setString(2,"RsQ8");
            preparedStatement.setString(3,"2022");

            System.out.println("Rows impacted: " + preparedStatement.executeUpdate());

            statement = connection.createStatement();
            resultSet = preparedStatement.executeQuery(query);

            System.out.println("id | brand | model | year | plate");
            while (resultSet.next()){
                int id = resultSet.getInt("Id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String year = resultSet.getString("release_year");
                String numberPlate = resultSet.getString("number_plate");
                Car car = new Car(id,brand,model,year,numberPlate);
                cars.add(car);

                //System.out.println(id + " | " + brand + " | " + model + " | " + year + " | " + numberPlate);
            }
            for (Car car : cars) {
                System.out.println(car.toString());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
