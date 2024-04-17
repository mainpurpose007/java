import javax.swing.*;
import java.awt.*;

public class pp30 extends JPanel {
    private final Color saffron = new Color(255, 153, 51);
    private final Color white = Color.WHITE;
    private final Color green = new Color(18, 136, 7);
    private final int flagWidth = 600;
    private final int flagHeight = 400;

    public pp30() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(flagWidth, flagHeight));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFlag(g);
    }

    private void drawFlag(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        // Drawing saffron color
        g.setColor(saffron);
        g.fillRect(0, 0, width, height / 3);

        // Drawing white color
        g.setColor(white);
        g.fillRect(0, height / 3, width, height / 3);

        // Drawing green color
        g.setColor(green);
        g.fillRect(0, 2 * height / 3, width, height / 3);

        // Drawing Ashoka Chakra
        drawAshokaChakra(g);
    }

    private void drawAshokaChakra(Graphics g) {
        int diameter = getHeight() / 3;
        int x = (getWidth() - diameter) / 2;
        int y = getHeight() / 6;
        // g.setColor(navyBlue);
        g.fillOval(x, y, diameter, diameter);

        // Drawing 24 spokes
        double angle = 0;
        int cx = x + diameter / 2;
        int cy = y + diameter / 2;
        int r = diameter / 2;

        for (int i = 0; i < 24; i++) {
            int endX = (int) (cx + r * Math.cos(Math.toRadians(angle)));
            int endY = (int) (cy + r * Math.sin(Math.toRadians(angle)));
            g.drawLine(cx, cy, endX, endY);
            angle += 360 / 24;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Indian Flag");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new pp30());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}




program 2


import java.io.*;
import java.sql.*;
import java.util.*;
class Slip25_2
{
public static void main(String args[])
{
Connection conn= null;
Statement stmt = null;
ResultSet rs = null;
int ch;
Scanner s=new Scanner(System.in);
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
conn=DriverManager.getConnection("jdbc:odbc:dsn");
stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
rs = stmt.executeQuery("select * from employee");
int count=0;
while(rs.next())
count++;
System.out.println("Which Record u want");
System.out.println("Records are = "+count);
do
{ System.out.println("1 First \n2 last \n3 next \n4 prev \n0 Exit");
ch=s.nextInt();
switch(ch)
{
case 1: rs.first();
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2)); break;
case 2: rs.last();
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2)); break;
case 3 : rs.next();
if(rs.isAfterLast())
System.out.println("can't move forword");
else
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2));
break;
case 4 : rs.previous();
NR CLASSES, PUNE (8796064387/90)
if(rs.isBeforeFirst())
System.out.println("can't move backword");
else
System.out.println("Roll :"+rs.getInt(1)+" Name :"+rs.getString(2));
break;
case 0 : break;
default:System.out.println("Enter valid operation");
}
}while(ch!=0);
}
catch(Exception e)
{
System.out.println(e);
}
}
}