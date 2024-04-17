<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sum of First and Last Digit</title>
<style>
        .red-text {
                color: red;
                font-size: 18px;
                }
</style>
</head>
<body>
<h2>Sum of First and Last Digit</h2>
<form action="calculate.jsp" method="post">
<label for="numberInput">Enter a number:</label>
<input type="number" id="numberInput" name="number">
<button type="submit">Calculate</button>
</form>

<%-- Check if the number is submitted --%>
<% if (request.getParameter("number") != null) {
        int number = Integer.parseInt(request.getParameter("number"));
        int sum = calculateSum(number); %>

<%-- Display the sum in red color with font size 18 --%>
<p class="red-text">Sum of First and Last Digit: <%= sum %></p>
<% } %>

<%-- Java method to calculate sum of first and last digit --%>
<%!
public int calculateSum(int number) {
        // Convert number to string to extract digits
        String numStr = Integer.toString(number);
        int length = numStr.length();

        // Extract the first and last digits
        int firstDigit = Character.getNumericValue(numStr.charAt(0));
        int lastDigit = Character.getNumericValue(numStr.charAt(length - 1));

        // Calculate and return the sum
        return firstDigit + lastDigit;
        }
        %>
</body>
</html>
