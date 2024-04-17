import java.sql.*;

public class slip16_2 {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/Teacher";
        String username = "postgres";
        String password = "1234";

        String [][]Teachers = {
            {"Tenz" , "JAVA"},{"John","WT"}
        };

        try(Connection con = DriverManager.getConnection(url , username , password)){
            String query = "INSERT INTO TeacherTable VALUES(?,?);";
            PreparedStatement pstm = con.prepareStatement(query);
            for(String[] t : Teachers){
                pstm.setString(1,t[0]);
                pstm.setString(2,t[1]);
            }

            String selectQuery = "SELECT * FROM TeacherTable WHERE subject = ?;";
            pstm.setString(3 , "JAVA");
            ResultSet rs = pstm.executeQuery(selectQuery);

            System.out.println("Teacher Details ");
            while(rs.next()){
                System.out.println("Teacher number : " + rs.getInt("TNO"));
                System.out.println("Teacher number : " + rs.getString("TName"));
                System.out.println("Teacher number : " + rs.getString("TSubject"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
