import java.util.*;
public class pp2 {
public static void main(String[] args)
 {
Scanner input = new Scanner(System.in);
System.out.print("Enter the number of friends: ");
int n = input.nextInt();
Set<String> friends = new HashSet<>();
// Reading 'n' names from user
for (int i = 1; i <= n; i++) {
System.out.print("Enter name " + i + ": ");
String name = input.next();
friends.add(name);
}
// Sorting and displaying the names in ascending order
List<String> sortedFriends = new ArrayList<>(friends);
Collections.sort(sortedFriends);
System.out.println("\nList of friends in ascending order:");
for (String friend : sortedFriends) {
System.out.println(friend);
}
}
}



program 2


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

 class seta2 extends HttpServlet
 {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
    {
      try
       {  
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");        
        out.println("<body>");
        java.util.Properties p=System.getProperties();
        out.println("Server Name :"+req.getServerName()+"<br>");        
        out.println("Operating System Name :"+p.getProperty("Linux")+"<br>"); 
        out.println("IP Address :"+req.getRemoteAddr()+"<br>");        
        out.println("Remote User:"+req.getRemoteUser()+"<br>"); 
        out.println("Remote Host:"+req.getRemoteHost()+"<br>"); 
        out.println("Local Name :"+req.getLocalName()+"<br>");         
        out.println("Server Port:"+req.getServerPort()+"<br>");        
        out.println("Servlet Name :"+this.getServletName()+"<br>"); 
        out.println("Protocol Name :"+req.getProtocol()+"<br>");     
        out.println("</html>");                   
        out.println("</body>");
       }
       catch(Exception e)
       {
         e.printStackTrace();

       }
    }
 }
