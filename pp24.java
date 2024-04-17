import javax.swing.*;

public class pp24 extends JFrame {
    private JLabel label;

    public pp24() {
        setTitle("Text Scroll");
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel("Scrolling Text", SwingConstants.LEFT);
        add(label);

        Thread scrollThread = new Thread(new ScrollTask());
        scrollThread.start();
    }

    private class ScrollTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100); // Adjust scroll speed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String text = label.getText();
                char lastChar = text.charAt(text.length() - 1);
                String newText = lastChar + text.substring(0, text.length() - 1);
                label.setText(newText);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new pp24().setVisible(true);
            }
        });
    }
}

jsp

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username != null && password != null && username.equals(password)) {
        response.sendRedirect("Login.html?message=Login%20Successfully");
    } else {
        response.sendRedirect("Error.html?message=Login%20Failed");
    }
%>


login.html

<!DOCTYPE html>
<html>
<head>
    <title>Login Successful</title>
</head>
<body>
    <h1>Login Successfully</h1>
</body>
</html>


Erroe.html

<!DOCTYPE html>
<html>
<head>
    <title>Login Failed</title>
</head>
<body>
    <h1>Login Failed</h1>
</body>
</html>

