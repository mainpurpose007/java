class pp15
{
public static void main(String a[])
{
String S;
int p;
Thread t = Thread.currentThread();
S = t.getName();
System.out.println("\n Current Thread name : "+S);
p = t.getPriority();
System.out.println("\n Current thread priority : "+p);
t.setName("My Thread");
S = t.getName();
System.out.println("\nChanged Name : "+S); 
t.setPriority(2);
p = t.getPriority();
System.out.println("\nChanged Priority : "+p);
}
}


program 2


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class VisitServlet extends HttpServlet
{
    static int i=1;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String k=String.valueOf(i);
        Cookie c = new Cookie("visit",k);
        response.addCookie(c);
        int j=Integer.parseInt(c.getValue());
        if(j==1)
        {
            out.println("Welcome");
        }
        else
        {
            out.println("You visited "+i+" times");
        }
                i++;                       
    }
}

Web.xml file(servlet entry)
<?xml version="1.0" encoding="ISO-8859-1"?>
<web-app>
<servlet>
        <servlet-name>VisitServlet</servlet-name>
        <servlet-class>VisitServlet</servlet-class>
    </servlet>
<servlet-mapping>
        <servlet-name>VisitServlet</servlet-name>
        <url-pattern>/servlet/VisitServlet</url-pattern>
    </servlet-mapping>
</web-app>