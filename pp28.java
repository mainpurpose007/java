// <!DOCTYPE html>
// <html>
// <head>
//     <title>Reverse String</title>
// </head>
// <body>
//     <h2>Reverse String</h2>
//     <form method="post" action="ReverseString.jsp">
//         <label for="inputString">Enter a String:</label>
//         <input type="text" id="inputString" name="inputString" required>
//         <button type="submit">Reverse</button>
//     </form>
// </body>
// </html>


// jsp 

// <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
// <!DOCTYPE html>
// <html>
// <head>
//     <meta charset="UTF-8">
//     <title>Reverse String</title>
// </head>
// <body>
//     <h2>Reverse String</h2>
//     <%
//         String inputString = request.getParameter("inputString");
//         if (inputString != null && !inputString.isEmpty()) {
//             String reversedString = new StringBuilder(inputString).reverse().toString();
//     %>
//             <h3>Original String: <%= inputString %></h3>
//             <h3>Reversed String: <%= reversedString %></h3>
//     <%
//         }
//     %>
//     <a href="index.html">Go Back</a>
// </body>
// </html>


// program 2

public class pp28
{
	public static void main(String[] args)
	{
		// Get the current executing thread
		Thread currentThread = Thread.currentThread();
 
		// Print thread information
		System.out.println("Thread Name : " + currentThread.getName());
		System.out.println("Thread Priority : " + currentThread.getPriority());
		System.out.println("Thread State : " + currentThread.getState());
		System.out.println("Thread is Daemon : " + currentThread.isDaemon());
		System.out.println("Thread is Alive : " + currentThread.isAlive());
		System.out.println("Thread is Interrupted : " + currentThread.isInterrupted());
	}
}