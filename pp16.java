import java.util.*;
public class pp16
 {
public static void main(String[] args) {
TreeSet<String> colors = new TreeSet<String>();
colors.add("red");
colors.add("green");
colors.add("blue");
colors.add("yellow");
colors.add("orange");
System.out.println("Colors in ascending order: " + colors);
}
 }



 program 2

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 
 public class TeacherManagement {
     // Database connection parameters
     private static final String URL = "jdbc:postgresql://localhost:5432/your_database_name";
     private static final String USER = "your_username";
     private static final String PASSWORD = "your_password";
 
     public static void main(String[] args) {
         try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
             // Insert sample records
             insertRecords(conn);
 
             // Display teachers teaching "JAVA" subject
             displayJavaTeachers(conn);
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 
     private static void insertRecords(Connection conn) throws SQLException {
         String insertQuery = "INSERT INTO Teacher (TNo, TName, Subject) VALUES (?, ?, ?)";
         try (PreparedStatement statement = conn.prepareStatement(insertQuery)) {
             // Insert at least 5 records
             statement.setInt(1, 1);
             statement.setString(2, "John Doe");
             statement.setString(3, "JAVA");
             statement.executeUpdate();
 
             statement.setInt(1, 2);
             statement.setString(2, "Jane Smith");
             statement.setString(3, "C++");
             statement.executeUpdate();
 
             statement.setInt(1, 3);
             statement.setString(2, "Alice Johnson");
             statement.setString(3, "JAVA");
             statement.executeUpdate();
 
             statement.setInt(1, 4);
             statement.setString(2, "Bob Williams");
             statement.setString(3, "Python");
             statement.executeUpdate();
 
             statement.setInt(1, 5);
             statement.setString(2, "Charlie Brown");
             statement.setString(3, "JAVA");
             statement.executeUpdate();
 
             System.out.println("Records inserted successfully.");
         }
     }
 
     private static void displayJavaTeachers(Connection conn) throws SQLException {
         String selectQuery = "SELECT * FROM Teacher WHERE Subject = ?";
         try (PreparedStatement statement = conn.prepareStatement(selectQuery)) {
             statement.setString(1, "JAVA");
             try (ResultSet resultSet = statement.executeQuery()) {
                 System.out.println("Teachers teaching JAVA subject:");
                 System.out.println("TNo\tTName\tSubject");
                 while (resultSet.next()) {
                     int tNo = resultSet.getInt("TNo");
                     String tName = resultSet.getString("TName");
                     String subject = resultSet.getString("Subject");
                     System.out.println(tNo + "\t" + tName + "\t" + subject);
                 }
             }
         }
     }
 }
 