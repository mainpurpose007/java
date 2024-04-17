import java.sql.*;
public class DONOR {
    public static void main(String[] args) {
        try {
            // load a driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");

            Statement stmt = null;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from donor");

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("\t-------------------------------------------------");

            int count = rsmd.getColumnCount();
            System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
            System.out.println("\t-------------------------------------------------");
            for (int i = 1; i <= count; i++) 
            {
                System.out.println("\t\tColumn No : " + i);
                System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
                System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
                System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
                System.out.println();
            } // for
            System.out.println("\t--------------------------------------------------");

            rs.close();
            stmt.close();
            conn.close();
        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch
    }
}




program 2

html

<!DOCTYPE html>
<html>
<head>
    <title>Customer Search</title>
</head>
<body>
    <h2>Customer Search</h2>
    <form action="SearchServlet" method="post">
        <label for="customerNumber">Enter Customer Number:</label>
        <input type="text" id="customerNumber" name="customerNumber" required>
        <button type="submit">Search</button>
    </form>
</body>
</html>


SearchServlet

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Database connection parameters
    private static final String URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get customer number from request parameter
        String customerNumber = request.getParameter("customerNumber");
        
        // Initialize database connection
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Prepare SQL statement to search for customer
            String sql = "SELECT * FROM customer WHERE customer_number = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, customerNumber);
                
                // Execute query
                try (ResultSet resultSet = statement.executeQuery()) {
                    PrintWriter out = response.getWriter();
                    if (resultSet.next()) {
                        // Customer found, retrieve and display details
                        String customerName = resultSet.getString("customer_name");
                        String customerEmail = resultSet.getString("customer_email");
                        String customerPhone = resultSet.getString("customer_phone");
                        
                        out.println("<h2>Customer Details</h2>");
                        out.println("<p>Customer Number: " + customerNumber + "</p>");
                        out.println("<p>Customer Name: " + customerName + "</p>");
                        out.println("<p>Customer Email: " + customerEmail + "</p>");
                        out.println("<p>Customer Phone: " + customerPhone + "</p>");
                    } else {
                        // Customer not found
                        out.println("<h2>Error</h2>");
                        out.println("<p>Customer with number " + customerNumber + " not found.</p>");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database access error", e);
        }
    }
}


database.

CREATE TABLE customer (
    customer_id SERIAL PRIMARY KEY,
    customer_number VARCHAR(50) UNIQUE,
    customer_name VARCHAR(100),
    customer_email VARCHAR(100),
    customer_phone VARCHAR(20)
);
