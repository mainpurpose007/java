import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.sql.*;

class Project extends JFrame{
    private JTable table;
    Project(){
        setSize(400 , 600);
        setTitle("Project Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table = new JTable();
        JScrollPane scroll = new JScrollPane(table);
        getContentPane().add(scroll);
        DisplayData();
    }

    private void DisplayData(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection con;
            String url = "jdbc:postgres://localhost/Project";
            String username = "postgres";
            String password = "1234";
            String q = "SELECT * FROM project;";
            con = DriverManager.getConnection(url , username , password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Project Id");
            model.addColumn("Project Name ");
            model.addColumn("Project size");

            while(rs.next()){
                model.addRow(new Object[]{
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getString("psize")
                });
            }

            table.setModel(model);

            rs.close();
            st.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

public class slip12_2 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           Project p = new Project();
           p.setVisible(true);
        });
    }

}
