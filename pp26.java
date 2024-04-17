importjava.sql.*;
class Slip27_1
{
public static void main(String a[])
{
Connection con;
PreparedStatementps;
ResultSetrs;
try
{
  Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");
if(con==null)
{
System.out.println("Connection Failed....");
System.exit(1);
}
System.out.println("Connection Established...");
ps=con.prepareStatement("select * from employee where eid=?");
int id = Integer.parseInt(a[0]);
ps.setInt(1,id);

rs=ps.executeQuery();
System.out.println("eno\t"+"ename\t"+"department\t"+"sal"); while(rs.next())
{
System.out.println("\n"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.ge tInt(4));
}
con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}


program 2


HTML FILE

<html>
<body>
<form method=post action="Slip7.jsp">
Enter Any Number : <Input type=text name=num>
<input type=submit value=Display>
</form>
</body>
</html>

JSP FILE:
<%@page contentType="text/html" pageEncoding="UTF-8">
<!DOCTYPE html>
<html>
<body>
<%! intn,rem,r; %>
<% n=Integer.parseInt(request.getParameter("num"));
if(n<10)
{
out.println("Sum of first and last digit is ");
%><font size=18 color=red><%= n %>
<%
}
else
{
rem=n%10;
do
{
r=n%10;
n=n/10;
}while(n>0);
n=rem+r;
out.println("Sum of first and last digit is ");
%><font size=18 color=red><%= n %>
<%
}
%>
</body>
</html>
