import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SearchServlet")
public class slip11_1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get customer number from request parameter
        String customerNumber = request.getParameter("customerNumber");
        String customerDetails = "";

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/yourdatabase";
        String username = "yourusername";
        String password = "yourpassword";

        // Establish database connection and execute query
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM customers WHERE customer_number = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, customerNumber);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // Retrieve customer details
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        // You can retrieve other details similarly

                        // Format customer details for display
                        customerDetails = "Name: " + name + "<br>Email: " + email;
                    } else {
                        // Customer not found
                        customerDetails = "Customer not found";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            customerDetails = "Error retrieving customer details";
        }

        // Generate HTML response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Customer Details</h2>");
        out.println(customerDetails);
        out.println("</body></html>");
    }
}
