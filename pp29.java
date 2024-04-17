import java.sql.*;

public class pp29 {
    public static void main(String[] args) {
        try {
            // load a driver
            Class.forName("org.postgresql.Driver");
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
            }  
            System.out.println("\t--------------------------------------------------");

            rs.close();
            stmt.close();
            conn.close();
        }  
        catch (Exception e) {
            System.out.println(e);
        }  
    }
}


program 2

import java.util.LinkedList;

public class pp29 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        System.out.println("Original LinkedList: " + linkedList);
        linkedList.addFirst(5);
        System.out.println("After adding element at first position: " + linkedList);
        if (!linkedList.isEmpty()) {
            linkedList.removeLast();
        } else {
            System.out.println("List is empty. Cannot delete last element.");
        }
        System.out.println("After deleting last element: " + linkedList);
        System.out.println("Size of LinkedList: " + linkedList.size());
    }
}
