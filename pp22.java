import java.sql.*;
import java.util.Scanner;

public class pp22 {
    private static final String URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            boolean exit = false;
            while (!exit) {
                System.out.println("\nMenu:");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        insertEmployee(conn, scanner);
                        break;
                    case 2:
                        updateEmployee(conn, scanner);
                        break;
                    case 3:
                        displayEmployees(conn);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter employee number: ");
        int eNo = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter employee name: ");
        String eName = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        String insertQuery = "INSERT INTO Employee (ENo, EName, Salary) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(insertQuery)) {
            statement.setInt(1, eNo);
            statement.setString(2, eName);
            statement.setDouble(3, salary);
            statement.executeUpdate();
            System.out.println("Employee inserted successfully.");
        }
    }

    private static void updateEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter employee number to update: ");
        int eNo = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new employee name: ");
        String eName = scanner.nextLine();
        System.out.print("Enter new employee salary: ");
        double salary = scanner.nextDouble();

        String updateQuery = "UPDATE Employee SET EName = ?, Salary = ? WHERE ENo = ?";
        try (PreparedStatement statement = conn.prepareStatement(updateQuery)) {
            statement.setString(1, eName);
            statement.setDouble(2, salary);
            statement.setInt(3, eNo);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee with number " + eNo + " not found.");
            }
        }
    }

    private static void displayEmployees(Connection conn) throws SQLException {
        String selectQuery = "SELECT * FROM Employee";
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            System.out.println("Employee Details:");
            System.out.println("ENo\tEName\tSalary");
            while (resultSet.next()) {
                int eNo = resultSet.getInt("ENo");
                String eName = resultSet.getString("EName");
                double salary = resultSet.getDouble("Salary");
                System.out.println(eNo + "\t" + eName + "\t" + salary);
            }
        }
    }
}




program 2

/* slip22html*/

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form action="Slip22.jsp" method="post">
            Enter Your Name : <input type="text" name="name"><br>
           
            <input type="submit" value="Submit">
        </form>
    </body>
</html>

/*slip22.jsp*/

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    String name = request.getParameter("name");
   
   Calendar rightnow = Calendar.getInstance();
   int time = rightnow.get(Calendar.HOUR_OF_DAY);
  
    if(time > 0 && time <= 12)
    {
        out.println("Good Morning"+name);
    }
      else if(time < 12 && time >=16)
      {
          out.println("Good Afternoon"+name);
      }
      else
      {
          out.println("Good Night"+name);
      }
%>
