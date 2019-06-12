package pl.coderslab.cookie;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToCookie")
public class Cookie2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String time = request.getParameter("time");

        Cookie cookie = new Cookie(key, value);
        if (StringUtils.isNotBlank(time) && StringUtils.isNumeric(time)) {
            int hours = Integer.parseInt(time);
            cookie.setMaxAge(hours * 60 * 60);
        }

        response.addCookie(cookie);
        response.getWriter().append("Ciasteczko dodane");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index2.html");
    }
}
