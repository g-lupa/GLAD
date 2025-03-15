<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Spotify Clone - Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #181818;
            color: #fff;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 400px;
            margin: 50px auto;
            text-align: center;
        }
        a {
            color: #1DB954;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1><%= request.getAttribute("welcomeMessage") %></h1>
        <p>You have successfully logged in to your GLAD Account.</p>
       
        <p><a href="dashboard">Go to Your Dashboard</a></p>
    </div>
</body>
</html>



