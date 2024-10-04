package com.example.healthapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:postgresql://Postgres-db:5432/yourdatabase";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "yourpassword";

    public static void saveUserData(String firstName, String lastName, int age, double weight, double height, double bmi, String healthStatus) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Connexion à la base de données
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Préparer la requête SQL
            String sql = "INSERT INTO users (first_name, last_name, age, weight, height, bmi, health_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setDouble(4, weight);
            preparedStatement.setDouble(5, height);
            preparedStatement.setDouble(6, bmi);
            preparedStatement.setString(7, healthStatus);

            // Exécuter la requête
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
