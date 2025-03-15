<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>GLAD - Error</title>
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
        .error {
            color: #ff5555;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="error"><%= request.getAttribute("errorMessage") %></h1>
        <p><a href="index.html">Go back to Landing Page</a></p>
    </div>
</body>
</html>