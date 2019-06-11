package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/get2")
public class Get2 extends HttpServlet {

    // http://localhost:8080/get2?param=1&param=2&param=3&a=1&b=2&c=20&c=10
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        PrintWriter writer = response.getWriter();

        for (String key : parameterMap.keySet()) {
            String[] values = parameterMap.get(key);
            writer.append(key)
                    .append(": ")
                    .append(Arrays.toString(values))
                    .append("\n");
        }
    }
}
