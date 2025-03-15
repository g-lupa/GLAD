package ryerson.ca.lab3.Business;

import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PlaylistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public static class Song {
        private String title;
        private String artist;

        public Song(String title, String artist) {
            this.title = title;
            this.artist = artist;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }
    }

    public static class Playlist {
        private String name;
        private List<Song> songs;

        public Playlist(String name, List<Song> songs) {
            this.name = name;
            this.songs = songs;
        }

        public String getName() {
            return name;
        }

        public List<Song> getSongs() {
            return songs;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            request.setAttribute("errorMessage", "Please log in to view your playlists.");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            return;
        }

        String selectedPlaylist = request.getParameter("playlist");

        // Dummy data for playlists
        Map<String, Playlist> userPlaylists = new HashMap<>();
        userPlaylists.put("Default Playlist", new Playlist("Default Playlist",
                Arrays.asList(new Song("Imagine", "John Lennon"), new Song("Bohemian Rhapsody", "Queen"))));
        userPlaylists.put("Rock Classics", new Playlist("Rock Classics",
                Arrays.asList(new Song("Back In Black", "AC/DC"), new Song("Hotel California", "Eagles"))));
        userPlaylists.put("Pop Hits", new Playlist("Pop Hits",
                Arrays.asList(new Song("Blinding Lights", "The Weeknd"), new Song("Shape of You", "Ed Sheeran"))));

        request.setAttribute("playlists", userPlaylists.keySet());

        if (selectedPlaylist != null && userPlaylists.containsKey(selectedPlaylist)) {
            request.setAttribute("selectedPlaylist", userPlaylists.get(selectedPlaylist));
            RequestDispatcher dispatcher = request.getRequestDispatcher("playlist.jsp");
            dispatcher.forward(request, response);
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
