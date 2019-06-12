package pl.coderslab.session;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sess02")
public class Sess02 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        // Pobranie parametru wysłanego metodą post z formularza
        String grade = request.getParameter("grade");

        // Pobranie listy ocen z sesji
        HttpSession session = request.getSession();
        List<Integer> grades = (List<Integer>) session.getAttribute("grades");
        // Jeśli nie było w sesji to tworzę nową listę
        if (grades == null) {
            grades = new ArrayList<>();
        }

        // Sprawdzenie poprawności podanej wartości
        if (StringUtils.isNotBlank(grade) && StringUtils.isNumeric(grade)) {
            // Dodanie oceny do listy
            grades.add(Integer.parseInt(grade));
            // Dodanie listy z ocenami do sesji
            session.setAttribute("grades", grades);
        } else {
            response.getWriter().append("Nieprawidłowa ocena");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        response.getWriter().append("<form method='post'>")
                .append("<label>Ocena:")
                .append("<input type='number' name='grade'>")
                .append("</label>")
                .append("<input type='submit' value='Zapisz'>")
                .append("</form>");
    }
}
