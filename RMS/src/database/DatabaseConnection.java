package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class DatabaseConnection {

    // Method to establish a connection and return the connection object
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");  // Correct driver class name

            // Establish connection
            String url = "jdbc:mysql://localhost:3306/MYDB"; // Replace with your DB URL
            String user = "root";  // Replace with your DB username
            String password = "admin123";  // Replace with your DB password

            // Create the connection object
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection succesfull");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;  // Return the connection object
    }
    
    // Method to fetch all users from the users table
    public static ResultSet getAllUsers() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                rs = statement.executeQuery("SELECT * FROM users");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing query", ex);
        }
        return rs;  // Return the ResultSet containing all users
    }
    
    // Method to insert a new user into the users table
    public static int insertUser(int id,String username,String lastname,String email) {
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            connection = getConnection();
            String query = "INSERT INTO users (id,username,lastname, email) VALUES (?, ?, ?,?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);          // Bind the 'id' parameter
            ps.setString(2, username);     // Bind the 'name' parameter
            ps.setString(3, lastname);
            ps.setString(4, email);    // Bind the 'email' parameter
        
            result = ps.executeUpdate();  // Executes the insert query
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing insert query", ex);
        } finally {
            closeResources(connection, ps, null);  // Close the resources
        }

        return result;  // Return the result of the insert operation
    }

    // Method to update a user's email based on their id
    public static int updateUserEmail(int id, String newEmail) {
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            connection = getConnection();
            String query = "UPDATE users SET email = ? WHERE id = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, newEmail);
            ps.setInt(2, id);
            result = ps.executeUpdate();  // Executes the update query
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing update query", ex);
        } finally {
            closeResources(connection, ps, null);  // Close the resources
        }

        return result;  // Return the result of the update operation
    }
    
   public static boolean registerUser(String username, String password, String securityAnswer) {
    String query = "INSERT INTO users (username, password, security_answer) VALUES (?, ?, ?)";

    try (Connection connection = getConnection();
         PreparedStatement ps = connection.prepareStatement(query)) {
        ps.setString(1, username);
        ps.setString(2, password); // Plaintext password (not secure, use only in controlled environments)
        ps.setString(3, securityAnswer);
        return ps.executeUpdate() > 0; // Return true if the insertion was successful
    } catch (SQLException e) {
        e.printStackTrace(); // Replace with proper logging
        return false;
        }
    }


//     Method to close the resources
    public static void closeResources(Connection connection, Statement statement, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error closing resources", ex);
        }
    }
    
}

