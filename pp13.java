import java.sql.*;

public class pp13 {
	public static void main(String[] args) {
		try {
			// load a driver
			Class.forName("org.postgresql.Driver");

			// Establish Connection
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println("\t-----------------------------------------------------------------------");
			System.out.println("\t\tDriver Name : " + dbmd.getDriverName());
			System.out.println("\t\tDriver Version : " + dbmd.getDriverVersion());
			System.out.println("\t\tUserName : " + dbmd.getUserName());
			System.out.println("\t\tDatabase Product Name : " + dbmd.getDatabaseProductName());
			System.out.println("\t\tDatabase Product Version : " + dbmd.getDatabaseProductVersion());
			System.out.println("\t---------------------------------------------------------------------");

			String table[] = { "TABLE" };
			ResultSet rs = dbmd.getTables(null, null, null, table);
			System.out.println("\t\tTable Names:");

			while (rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
			rs.close();
			conn.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}  
	} 
} 


program 2

Class MyThread extends Thread
{ 
    public MyThread(String s)
{
super(s);
}
public void run()
{
System.out.println(getName()+"thread created.");
while(true)
{
System.out.println(this);
int s=(int)(math.random()*5000);
System.out.println(getName()+"is sleeping for :+s+"msec");
try{
Thread.sleep(s);
}
catch(Exception e)
{
}
}
}
Class ThreadLifeCycle
{
public static void main(String args[])
{
MyThread t1=new MyThread("shradha"),t2=new MyThread("pooja");
t1.start();
t2.start();
try
{
t1.join();
t2.join();
}
catch(Exception e)
{
}
System.out.println(t1.getName()+"thread dead.");
System.out.println(t2.getName()+"thread dead.");
}
}