 download servlet-api-jar https://tomcat.apache.org/

            use this in WEB-INF -> web.xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
        version="4.0">
<servlet>
<servlet-name>slip15_2</servlet-name>
<servlet-class>slip15_2</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>slip15_2</servlet-name>
<url-pattern>/slip15_2</url-pattern>
</servlet-mapping>
</web-app>

your-web-app/
            ├── slip15_2.java


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


    @WebServlet("/slip15_2")
    public class slip15_2 extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            int count = 0;
            boolean isNewUser = true;

            // Get the cookies associated with the request
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("visitCount")) {
                        isNewUser = false;
                        count = Integer.parseInt(cookie.getValue());
                        break;
                    }
                }
            }

            // Increment the visit count if it's not a new user
            if (!isNewUser) {
                count++;
            }

            // Create or update the cookie with the visit count
            Cookie visitCountCookie = new Cookie("visitCount", String.valueOf(count));
            visitCountCookie.setMaxAge(24 * 60 * 60); // Cookie valid for 24 hours
            response.addCookie(visitCountCookie);

            // Display welcome message for new user or count for returning user
            response.setContentType("text/html");
            if (isNewUser) {
                response.getWriter().println("<h1>Welcome to our website!</h1>");
            } else {
                response.getWriter().println("<h1>You have visited this page " + count + " times.</h1>");
            }
        }
    }

}