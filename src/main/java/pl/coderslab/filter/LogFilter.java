package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        HttpServletRequest request = (HttpServletRequest) req;
        String user = request.getHeader("User-Agent");
        String browser = "";
        if (user.contains("Chrome")) {
            browser = "Google Chrome";
        } else if (user.contains("Firefox")) {
            browser = "Mozilla Firefox";
        } else if (user.contains("Opera")) {
            browser = "Opera";
        } else if (user.contains("Safari")) {
            browser = "Safari";
        }

        long startTime = System.currentTimeMillis();

        chain.doFilter(req, resp);

        long stopTime = System.currentTimeMillis();

        long sec = stopTime - startTime;
        resp.getWriter().append("<br><br>Took : " + sec + " miliseconds<br>");
        resp.getWriter().append("User-Agent: " + browser + "<br>");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
