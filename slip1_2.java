import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class EmployeeDetails extends JFrame implements ActionListener{

    private JTextField eno , ename, edesignation , esalary;
    private JButton sb;

    private Connection con;

    public EmployeeDetails(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,2,10,10));

        panel.add(new JLabel("Employee ID : "));
        eno = new JTextField();
        panel.add(eno);

        panel.add(new JLabel("Employee Name : "));
        ename = new JTextField();
        panel.add(ename);

        panel.add(new JLabel("Designation : "));
        edesignation = new JTextField();
        panel.add(edesignation);

        panel.add(new JLabel("Salary : "));
        esalary = new JTextField();
        panel.add(esalary);

        sb = new JButton("Save Data");
        sb.addActionListener(this);
        panel.add(sb);

        add(panel);
        setVisible(true);

        try{
            Class.forName("jdbc.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/employee";
            String username = "localhost";
            String password = "1234";
            con = DriverManager.getConnection(url,username,password);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sb){
            saveDetails();
        }
    }

    public void saveDetails(){
        try{
            String query = "INSERT INTO empdetails VALUES (?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,Integer.parseInt(eno.getText()));
            ps.setString(2,ename.getText());
            ps.setString(3,edesignation.getText());
            ps.setInt(4,Integer.parseInt(esalary.getText()));
            int identify = ps.executeUpdate();
            if(identify > 0){
                JOptionPane.showMessageDialog(this,"Data was inserted successfully.");
            }else{
                JOptionPane.showMessageDialog(this , "Opps Data was not send");
            }

            ps.close();
        }catch(Exception queryError){
            queryError.printStackTrace();
        }
    }
}

public class slip1_2 {
    public static void main(String[] args) {
        EmployeeDetails e = new EmployeeDetails();
    }
}
