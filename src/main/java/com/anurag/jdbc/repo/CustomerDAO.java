package com.anurag.jdbc.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomerDAO {
    private final DataSource dataSource;


    //todo spring lay self == datasource ko object inject gardinxa
    @Autowired
    public CustomerDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getCustomerName(int customerId) throws DataAccessException {
        String query = "SELECT name FROM people WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            throw new DataAccessResourceFailureException("Failed to get customer name", e);
        }
        return null;
    }
}
