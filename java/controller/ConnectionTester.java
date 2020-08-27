package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;
@Controller
@RequestMapping("/test")
public class ConnectionTester extends HttpServlet {

    @RequestMapping(value = "checkconnection")
    @ResponseBody
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><TITLE>HELLO</TITLE></HEAD>");
        out.println("<BODY>");
/*
        out.println("Hello World");
*/
        out.println("<BIG>HI</BIG>");
        out.println("</BODY></HTML>");
        res.sendRedirect("/CheckConnection.jsp");
    }
}
