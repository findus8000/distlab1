package db;

import bo.Customer;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;

public class CustomerDB extends bo.Customer{

    public static boolean addUserToDB(Customer customer) throws SQLException {

        String sql = "INSERT INTO Customer (FirstName, LastName, Email, PhoneNumber, PasswordHash) VALUES (?, ?, ?, ?, ?)";
        try{
            Connection con = DBManager.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);


       
            stmt.setString(1, customer.getFirstName());  // ProductName
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhoneNumber());
            stmt.setString(5, customer.getPasswordHash());
            
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new product was inserted successfully!");
                stmt.close();
                return true;
            }

            stmt.close();
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Collection getCustomersByEmailFromDB(String email) {
        Vector v = new Vector();
        String sql = "SELECT * FROM Customer WHERE Email = ?";
        try {
            Connection c = DBManager.getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery( );

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String name = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String email1 = rs.getString("Email");
                String phoneNumber = rs.getString("PhoneNumber");
                String password = rs.getString("PasswordHash");
                v.addElement(new CustomerDB(id,password,phoneNumber, email1, lastName ,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    public CustomerDB(int customerID, String passwordHash, String phoneNumber, String email, String lastName, String firstName) {
        super(customerID, passwordHash, phoneNumber, email, lastName, firstName);
    }

}
