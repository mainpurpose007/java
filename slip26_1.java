import java.sql.*;

public class slip26_1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Q1_11720 <EmployeeID>");
            return;
        }

        int employeeID = Integer.parseInt(args[0]);

        String url = "jdbc:postgresql://localhost:5432/EmployeeDB";
        String user = "postgres";
        String password = "1234";

        String deleteQuery = "DELETE FROM Employee WHERE ENo = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {

            pstmt.setInt(1, employeeID);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee details deleted successfully for employee ID: " + employeeID);
            } else {
                System.out.println("Employee with ID " + employeeID + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
