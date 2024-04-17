public class pp1 extends Thread
{
char c;
public void run()
{
for(c = 'A'; c<='Z';c++)
{
System.out.println(""+c);
try

{
Thread.sleep(3000);
}
catch(Exception e)
{
e.printStackTrace();
}
}
}
public static void main(String args[])
{
pp1 t = new pp1();
t.start();
}
}


program 2



import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;

class one extends JFrame implements ActionListener {

      JFrame f;
      JLabel l1, l2, l3;
      JTextField t1, t2, t3;
      JButton b1, b2;

      one() {
            f = new JFrame("slp1");
            l1 = new JLabel("eno");
            l2 = new JLabel("ename");
            l3 = new JLabel("salary");
            t1 = new JTextField(15);
            t2 = new JTextField(15);
            t3 = new JTextField(15);
            b1 = new JButton("Insert ");
            b2 = new JButton("clear ");
            f.setLayout(new FlowLayout());
            f.setVisible(true);
            f.setSize(300, 300);
            b1.addActionListener(this);
            b2.addActionListener(this);
            f.add(l1);
            f.add(t1);
            f.add(l2);
            f.add(t2);
            f.add(l3);
            f.add(t3);
            f.add(b1);
            f.add(b2);
      }

      public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                  try {
                        Class.forName("org.postgresql.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");

                        Statement stmt = con.createStatement();

                        String name = t2.getText();
                        int eno = Integer.parseInt(t1.getText());
                        int sal = Integer.parseInt(t3.getText());
                        String sql = "insert into emp values(";
                        sql = sql + eno + ",'" + name + "'," + sal + ")";
                        System.out.println(sql);
                        int i = stmt.executeUpdate(sql);
                        if (i > 0) {
                              System.out.println("record added ");
                        }
                        con.close();
                  } // try close
                  catch (Exception a) {
                  }
            }

            if (e.getSource() == b2) {
                  t1.setText("");
                  t2.setText("");
                  t3.setText("");
            }
      }// action performed close
}// one close

class slip1 {
      public static void main(String args[]) {
            one o = new one();
      }
}
