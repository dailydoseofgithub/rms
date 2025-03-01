package database;

import java.util.List;
import java.util.ArrayList;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public static int insertItem(String name, int price, boolean isVeg) {
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;
        
        boolean is_veg;
//        if (isVeg==1){
//            is_veg = true;
//        }
        try {
            connection = getConnection();
            String query = "INSERT INTO items (name,isVeg,price) VALUES (?, ?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, name);   
            ps.setBoolean(2, isVeg);    
            ps.setInt(3,price);
            
            result = ps.executeUpdate();  // Executes the insert query
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing insert query", ex);
        } finally {
            closeResources(connection, ps, null);  // Close the resources
        }

        return result;  // Return the result of the insert operation
    }
    public static int insertStock(int itemnumber, String itemname, int quantity) {
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;
//        if (isVeg==1){
//            is_veg = true;
//        }
        try {
            connection = getConnection();
            String query = "INSERT INTO inventory (itemId,name,quantity) VALUES (?, ?,?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, itemnumber);   
            ps.setString(2, itemname);    
            ps.setInt(3,quantity);
            
            result = ps.executeUpdate();  // Executes the insert query
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing insert query", ex);
        } finally {
            closeResources(connection, ps, null);  // Close the resources
        }

        return result;  // Return the result of the insert operation
    }
    public static int makeOrder(String itemname, int tablenumber, int quantity) {
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;
//        if (isVeg==1){
//            is_veg = true;
//        }
        try {
            connection = getConnection();
            String query = "INSERT INTO orders (itemName,tableNumber,Quantity) VALUES (?, ?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, itemname);   
            ps.setInt(2, tablenumber);    
            ps.setInt(3,quantity);
            
            result = ps.executeUpdate();  // Executes the insert query
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing insert query", ex);
        } finally {
            closeResources(connection, ps, null);  // Close the resources
        }

        return result;  // Return the result of the insert operation
    }
    public static int addStaff(String username,String number,String position,String salary,String dateJoined) {
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateJoined);
            System.out.println("date converted");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = getConnection();
            String query = "INSERT INTO staffs (staffName,contact,position,salary,dateJoined) VALUES (?, ?,?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, username);   
            ps.setString(2, number);    
            ps.setString(3,position);
            ps.setString(4,salary);
            ps.setDate(5,new java.sql.Date(date.getTime()));
            
            result = ps.executeUpdate();  // Executes the insert query
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing insert query", ex);
        } finally {
            closeResources(connection, ps, null);  // Close the resources
        }

        return result;  // Return the result of the insert operation
    }
    public static int makeReservation(String username,String contacts,String dateJoined) {
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateJoined);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = getConnection();
            String query = "INSERT INTO reservations (reservatorName,contact,date) VALUES (?, ?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, username);   
            ps.setString(2, contacts);    
            ps.setDate(3,new java.sql.Date(date.getTime()));
            
            result = ps.executeUpdate();  // Executes the insert query
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing insert query", ex);
        } finally {
            closeResources(connection, ps, null);  // Close the resources
        }

        return result;  // Return the result of the insert operation
    }
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
   public static List<List<Object>> getReservations() {
        List<List<Object>> reservations = new ArrayList<>();

        String query = "SELECT * FROM reservations";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                List<Object> reservation = new ArrayList<>();
                reservation.add(rs.getString("reservatorName")); 
                reservation.add(rs.getString("contact")); 
                reservation.add(rs.getDate("date"));

                reservations.add(reservation);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing query", ex);
        }

        return reservations;
    }
   public static List<List<Object>> getItems() {
        List<List<Object>> itemList = new ArrayList<>();

        String query = "SELECT * FROM items";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                List<Object> item = new ArrayList<>();
                item.add(rs.getString("name"));   // Column "name"
                item.add(rs.getBoolean("isVeg")); // Column "isVeg"
                item.add(rs.getInt("price"));     // Column "price"

                itemList.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing query", ex);
        }

        return itemList;
    }
   public static List<List<Object>> getOrder() {
        List<List<Object>> orders = new ArrayList<>();

        String query = "SELECT * FROM orders";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                List<Object> order = new ArrayList<>();
                order.add(rs.getString("itemName")); 
                order.add(rs.getInt("Quantity")); 
                order.add(rs.getInt("tableNumber")); 

                orders.add(order);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing query", ex);
        }

        return orders;
    }
   public static List<List<Object>> getInventory() {
        List<List<Object>> inventory = new ArrayList<>();

        String query = "SELECT * FROM inventory";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                List<Object> item = new ArrayList<>();
                item.add(rs.getInt("itemId")); 
                item.add(rs.getString("name")); 
                item.add(rs.getInt("quantity"));

                inventory.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing query", ex);
        }

        return inventory;
    }
   public static List<List<Object>> getStaffs(String id) {
        List<List<Object>> staffs = new ArrayList<>();
        String query = "SELECT * FROM staffs WHERE staffName = ?";  // Correct query syntax

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);  // Set the ID in query
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                List<Object> staff = new ArrayList<>();
                staff.add(rs.getString("staffName"));
                staff.add(rs.getString("contact"));
                staff.add(rs.getString("position"));
                staff.add(rs.getString("salary"));
                staff.add(rs.getDate("dateJoined"));

                staffs.add(staff);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing query", ex);
        }
        System.out.println(staffs);
        return staffs;
    }
    public static List<List<Object>> updateStaff(String name, String contact, String position, String salary, String dateJoined) {
        List<List<Object>> staffs = new ArrayList<>();

        // Query to update the staff information
        String query = "UPDATE staffs SET contact = ?, position = ?, salary = ?, dateJoined = ? WHERE staffName = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the parameters for the update query
            preparedStatement.setString(1, contact);
            preparedStatement.setString(2, position);
            preparedStatement.setString(3, salary);
            preparedStatement.setString(4, dateJoined);
            preparedStatement.setString(5, name); // Set the staffName for the condition

            // Execute the update query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if any row was updated
            if (rowsAffected > 0) {
                System.out.println("Staff updated successfully.");
            } else {
                System.out.println("No staff found with that name.");
            }

            // Optionally, you can retrieve the updated staff data
            String selectQuery = "SELECT * FROM staffs WHERE staffName = ?";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
                selectStatement.setString(1, name);
                ResultSet rs = selectStatement.executeQuery();

                // Add the updated staff to the list
                while (rs.next()) {
                    List<Object> staff = new ArrayList<>();
                    staff.add(rs.getString("staffName"));
                    staff.add(rs.getString("contact"));
                    staff.add(rs.getString("position"));
                    staff.add(rs.getString("salary"));
                    staff.add(rs.getDate("dateJoined"));
                    staffs.add(staff);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing query", ex);
        }

        return staffs;
    }

   public static int deleteStaff(String name) {
    // SQL query to delete the staff with the given name
    String query = "DELETE FROM staffs WHERE staffName = ?";
    int result =0;
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        // Set the staffName parameter in the query
        preparedStatement.setString(1, name);

        // Execute the delete query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check if any row was deleted
        if (rowsAffected > 0) {
            System.out.println("Staff deleted successfully.");
            result =1;
        } else {
            System.out.println("No staff found with that name.");
        }

    } catch (SQLException ex) {
        Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing query", ex);
    }
    return result;
}
   
   public static boolean updatePassword(String username, String securityQuestionAnswer, String newPassword) {
    // Flag to track if the password was successfully updated
    boolean isUpdated = false;

    // SQL query to update the password
    String query = "UPDATE users SET password = ? WHERE username = ? AND security_answer = ?";

    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        // Set the parameters for the update query
        preparedStatement.setString(1, newPassword); // Set the new password
        preparedStatement.setString(2, username);    // Set the username for the condition
        preparedStatement.setString(3, securityQuestionAnswer); // Set the answer to the security question

        // Execute the update query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check if any row was updated
        if (rowsAffected > 0) {
            isUpdated = true; // Password updated successfully
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("No matching username or security question answer found.");
        }

    } catch (SQLException ex) {
        Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, "Error executing query", ex);
    }

    return isUpdated;
}
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

