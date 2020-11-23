<%-- 
    Document   : forgot
    Created on : Nov 21, 2020, 8:11:57 PM
    Author     : 834043
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot password</title>
    </head>
    <body>
        <form method="post">
            <h1>Forgot Password</h1>
            Please enter your email address to retrieve your password.
            <span>Email Address: </span>
            <input type="text" name="email">
            <input type="submit">
            ${message}
        </form>
    </body>
</html>
