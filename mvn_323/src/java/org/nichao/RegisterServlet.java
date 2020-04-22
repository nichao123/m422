package org.nichao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",urlPatterns = "/reg")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

         String name =request.getParameter("name");
         String pass =request.getParameter("pass");

        out.println(name+"<p/>");
        out.println(pass+"<p/>");



         String[] nows =request.getParameterValues("now");
        for (String now :
           nows ) {
            out.println(now+"&nbsp;");
        }

        HttpSession  session = request.getSession();


        session.setAttribute("uname",name);
        session.setAttribute("upass",pass);



        response.sendRedirect("show");



        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
