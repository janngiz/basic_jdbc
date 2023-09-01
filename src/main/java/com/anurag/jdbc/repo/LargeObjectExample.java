package com.anurag.jdbc.repo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

public class LargeObjectExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "your-username";
        String password = "your-password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Inserting a BLOB (Binary Large Object)
            String insertQuery = "INSERT INTO images (id, data) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, 1);
            InputStream imageStream = new FileInputStream("path/to/image.jpg");

            //todo
            insertStatement.setBlob(2, imageStream);
            insertStatement.executeUpdate();
            System.out.println("BLOB inserted successfully.");

            // Retrieving a BLOB
            String selectQuery = "SELECT data FROM images WHERE id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, 1);
            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
                Blob blob = resultSet.getBlob("data");
                // Process the BLOB data as needed
                System.out.println("BLOB retrieved successfully.");
            }

            // Inserting a CLOB (Character Large Object)
            String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
            String insertClobQuery = "INSERT INTO texts (id, content) VALUES (?, ?)";
            PreparedStatement insertClobStatement = connection.prepareStatement(insertClobQuery);
            insertClobStatement.setInt(1, 1);
            insertClobStatement.setString(2, text);
            insertClobStatement.executeUpdate();
            System.out.println("CLOB inserted successfully.");

            // Retrieving a CLOB
            String selectClobQuery = "SELECT content FROM texts WHERE id = ?";
            PreparedStatement selectClobStatement = connection.prepareStatement(selectClobQuery);
            selectClobStatement.setInt(1, 1);
            ResultSet clobResultSet = selectClobStatement.executeQuery();
            if (clobResultSet.next()) {
                Clob clob = clobResultSet.getClob("content");
                // Process the CLOB data as needed
                System.out.println("CLOB retrieved successfully.");
            }

            // Handling SQL data types
            String selectTypeQuery = "SELECT * FROM users WHERE id = ?";
            PreparedStatement selectTypeStatement = connection.prepareStatement(selectTypeQuery);
            selectTypeStatement.setInt(1, 1);
            ResultSet typeResultSet = selectTypeStatement.executeQuery();
            if (typeResultSet.next()) {
                int id = typeResultSet.getInt("id");
                String name = typeResultSet.getString("name");
                Date birthDate = typeResultSet.getDate("birth_date");
                // Process the data types as needed
                System.out.println("Data types retrieved successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
