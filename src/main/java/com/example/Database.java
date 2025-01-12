package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test_db"; // Адрес базы данных
        String user = "root"; // Имя пользователя
        String password = "Nik09012006"; // Пароль

        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        List<Book> books = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Все работает");

            String query = "SELECT * FROM books";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String author = resultSet.getString("author");
                String title = resultSet.getString("title");
                System.out.println(id + " | " + author + " | " + title);
            }
            String SQL = "INSERT INTO books (author, title) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, "Alexandre Dumas"); // Параметр 1 (author)
            preparedStatement.setString(2, "The Three Musketeers"); // Параметр 2 (title)

            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Добавлено строк: " + rowsInserted);

            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String author = resultSet.getString("author");
                String title = resultSet.getString("title");
                System.out.println(id + " | " + author + " | " + title);
            }
        }catch (SQLException e){
            System.out.println("Ошибка доступа к базе данных");
        }finally {
            // Закрытие ресурсов
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
