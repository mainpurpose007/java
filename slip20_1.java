<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number to Words Converter</title>
<style>
        .red-text {
                color: red;
                }
</style>
</head>
<body>
<h2>Number to Words Converter</h2>
<form action="convert.jsp" method="post">
<label for="numberInput">Enter a number:</label>
<input type="text" id="numberInput" name="number">
<button type="submit">Convert</button>
</form>

<%-- Check if the number is submitted --%>
<% if (request.getParameter("number") != null) { %>
<%-- Convert the number to words --%>
<% String number = request.getParameter("number");
        String words = convertToWords(number); %>

<%-- Display the result in red color --%>
<p class="red-text"><%= words %></p>
<% } %>

<%-- Java method to convert number to words --%>
<%!
        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

public String convertToWords(String number) {
        int num = Integer.parseInt(number);
        if (num == 0) {
        return "Zero";
        }
        if (num < 10) {
        return units[num];
        }
        if (num < 20) {
        return teens[num - 10];
        }
        if (num < 100) {
        return tens[num / 10] + " " + units[num % 10];
        }
        if (num < 1000) {
        return units[num / 100] + " Hundred " + convertToWords(Integer.toString(num % 100));
        }
        return "Number is too large to convert.";
        }
        %>
</body>
</html>
