package com.kodilla.jdbc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DbManagerTestSuite {

    private static DbManager dbManager;

    @BeforeAll
    static void setup() {
        dbManager = DbManager.getInstance();
    }

    @AfterAll
    static void cleanup() {
        // Closing the connection after all tests (optional, depending on how the DbManager is set up)
        try {
            if (dbManager.getConnection() != null && !dbManager.getConnection().isClosed()) {
                dbManager.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() throws SQLException {
        // Test if connection is valid
        Connection conn = dbManager.getConnection();
        assertTrue(conn.isValid(1));
    }

    @Test
    public void testSelectUsersWithAtLeastTwoPosts() throws SQLException {
        // Given
        Connection conn = dbManager.getConnection();
        Statement statement = conn.createStatement();

        // When: Query to find users with at least 2 posts
        String sqlQuery = "SELECT u.id, u.firstname, u.lastname, COUNT(p.id) AS post_count " +
                "FROM USERS u " +
                "JOIN POSTS p ON u.id = p.user_id " +
                "GROUP BY u.id " +
                "HAVING COUNT(p.id) >= 2;";

        ResultSet rs = statement.executeQuery(sqlQuery);

        // Then: Validate that the query returns at least one user with 2 or more posts
        boolean atLeastOneUser = false;
        while (rs.next()) {
            int userId = rs.getInt("id");
            String firstName = rs.getString("firstname");
            String lastName = rs.getString("lastname");
            int postCount = rs.getInt("post_count");

            System.out.println("User ID: " + userId + ", Name: " + firstName + " " + lastName + ", Post Count: " + postCount);

            if (postCount >= 2) {
                atLeastOneUser = true;
            }
        }

        rs.close();
        statement.close();

        // Asserting at least one user was found with 2 or more posts
        assertTrue(atLeastOneUser, "No users found with at least 2 posts.");
    }
}
