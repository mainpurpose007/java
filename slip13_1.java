import java.sql.*;

public class slip13_1 {
    public static void main(String[] args) {
        Connection con;
        String url = "jdbc:postgresql://localhost/template";
        String username = "postgres";
        String password = "1234";

        try{
            con = DriverManager.getConnection(url , username , password);
            DatabaseMetaData md = con.getMetaData();
            System.out.println("Database product Name " + md.getDatabaseProductName());
            System.out.println("Database Product Version : " + md.getDatabaseProductVersion());
            System.out.println("Driver manager : " + md.getDriverName());
            System.out.println("Driver version : " + md.getDriverVersion());

            ResultSet rs = md.getTables(null ,null , "%" , new String[]{"Table"});
            while(rs.next()){
                String tableName = rs.getString("name");
                System.out.println(tableName);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
