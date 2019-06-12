package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/showAllSession")
public class Sess03_All extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        /// Pobranie listy z sesji
        List<String> names = (List<String>) session.getAttribute("names");
        // Jeśli nie było w sesji
        if (names == null || names.size() == 0) {
            response.getWriter().append("Brak danych w sesji");
            return;
        }

        response.getWriter().append("<table border='1'>");
        for (String key : names) {
            String value = (String) session.getAttribute(key);
            response.getWriter().append("<tr>")
                    .append("<td>").append(key).append("</td>")
                    .append("<td>").append(value).append("</td>")
                    .append("</tr>");
        }
        response.getWriter().append("</table>");
    }
}
