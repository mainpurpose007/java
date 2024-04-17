<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prime Number Checker</title>
</head>
<body>
<h2>Prime Number Checker</h2>
<form method="post">
        Enter a number: <input type="text" name="number">
<input type="submit" value="Check">
</form>

<%!
        // Method to check if a number is prime
        boolean isPrime(int num) {
        if (num <= 1) {
        return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
        if (num % i == 0) {
        return false;
        }
        }
        return true;
        }
        %>

<%
        // Get the number from the form submission
        String numberStr = request.getParameter("number");

        // Check if a number is provided and it's a valid integer
        if (numberStr != null && numberStr.matches("\\d+")) {
        int number = Integer.parseInt(numberStr);
        boolean isPrime = isPrime(number);

        // Display the result in red color
        if (isPrime) { %>
<p style="color: red;"><%= number %> is a prime number.</p>
<% } else { %>
<p style="color: red;"><%= number %> is not a prime number.</p>
<% }
        } else if (numberStr != null) { %>
<p style="color: red;">Please enter a valid number.</p>
<% }
        %>
</body>
</html>
