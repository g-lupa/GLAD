<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
    <title>GLAD - Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #181818;
            color: #fff;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 600px;
            margin: 50px auto;
            text-align: center;
        }
        .logout {
            margin-top: 20px;
        }
        a {
            color: #1DB954;
            text-decoration: none;
            font-weight: bold;
        }
        .playlist {
            margin-top: 20px;
            padding: 10px;
            border: 1px solid #333;
            background-color: #222;
            border-radius: 8px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your GLAD Dashboard</h1>
        <p><%= request.getAttribute("dashboardMessage") != null ? request.getAttribute("dashboardMessage") : "Welcome to your music hub!" %></p>
        
        <div class="playlist">
            <h2>Your Playlists</h2>
            <ul>
                <%
                    Set<String> playlists = (Set<String>) request.getAttribute("playlists");
                    if (playlists != null && !playlists.isEmpty()) {
                        for (String playlist : playlists) {
                %>
                            <li><a href="PlaylistServlet?playlist=<%= playlist %>"><%= playlist %></a></li>
                <%
                        }
                    } else {
                %>
                        <li>No playlists available.</li>
                <%
                    }
                %>
            </ul>
        </div>

        <div class="logout">
            <a href="logout">Logout</a>
        </div>
    </div>
</body>
</html>
