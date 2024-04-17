import java.sql.*;

public class slip11_2 {
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("org.postgresql.Driver");
            Connection con;
            String url = "jdbc:postgresql://localhost/Donor";
            String username = "postgres";
            String password = "1234";
            con = DriverManager.getConnection(url , username , password);
            Statement stmt = con.createStatement();
            String query = "Select * from Donors where 1 = 0";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int countColumn = rsmd.getColumnCount();
            System.out.println("Donor informations");
            System.out.println();
            for(int i = 0; i < countColumn; i++){
                System.out.println("Donor Name : " + rsmd.getColumnName(i));
                System.out.println("Donor Data type : " + rsmd.getColumnType(i));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
