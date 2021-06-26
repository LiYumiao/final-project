package com.swufe.javaee.toy_music;

import com.swufe.javaee.toy_music.Utils.SongUtils;
import com.swufe.javaee.toy_music.model.Song;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns ="/index")
public class IndexServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Song> songs = SongUtils.recentSongs();
        request.setAttribute("songs", songs);

        String name = (String) request.getSession().getAttribute("user");
        if (name == null) {
            request.setAttribute("name", "Guest");
            request.setAttribute("LogName","Log in");
            request.setAttribute("LogLink","log-in.html");
        } else {
            request.setAttribute("name", name);
            request.setAttribute("LogName", "Log out");
            request.setAttribute("LogLink", "log-out");
        }

        request.getRequestDispatcher("home.jsp").forward(request, response);

    }
}