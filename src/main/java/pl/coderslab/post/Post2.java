package pl.coderslab.post;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post2")
public class Post2 extends HttpServlet {

    private final static String[] BAD_WORDS = {"cholera", "motylanoga", "kurde"};

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String description = request.getParameter("description");
        String agree = request.getParameter("agree");

        if (!"on".equals(agree)) {
            for (String badWord : BAD_WORDS) {
                if (description.contains(badWord)) {
                    String stars = badWord.replaceAll(".", "*");
                    description = StringUtils.replace(description, badWord, stars);
                }
            }
        }

        response.getWriter().append(description);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index_2.html");
    }
}
