<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="ryerson.ca.lab3.PlaylistServlet.Song" %>
<%@ page import="ryerson.ca.lab3.PlaylistServlet.Playlist" %>
<!DOCTYPE html>
<html>
<head>
    <title>GLAD - Playlist</title>
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
        .back {
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
        .song {
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your Playlist</h1>
        <%
            Playlist selectedPlaylist = (Playlist) request.getAttribute("selectedPlaylist");
            if (selectedPlaylist != null) {
        %>
            <h2><%= selectedPlaylist.getName() %></h2>
            <ul>
                <%
                    List<Song> songs = selectedPlaylist.getSongs();
                    if (songs != null && !songs.isEmpty()) {
                        for (Song song : songs) {
                %>
                            <li class="song"><%= song.getTitle() %> - <%= song.getArtist() %></li>
                <%
                        }
                    } else {
                %>
                        <li>No songs in this playlist.</li>
                <%
                    }
                %>
            </ul>
        <%
            } else {
        %>
            <p>No playlist selected.</p>
        <%
            }
        %>

        <div class="back">
            <a href="PlaylistServlet">Back to Dashboard</a>
        </div>
    </div>
</body>
</html>
