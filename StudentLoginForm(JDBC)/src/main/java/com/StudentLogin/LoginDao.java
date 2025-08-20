package com.StudentLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDao {
    public boolean insert(User user) {
        Connection con = null;
        boolean result = false;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "45654");
            String query = "INSERT INTO login(username, password) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            int rowsAffected = pst.executeUpdate(); // Use executeUpdate() for insert operations
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
