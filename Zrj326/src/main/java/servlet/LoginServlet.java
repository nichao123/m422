package Zrj326.src.main.java.servlet;

import pojo.Userinfo;
import service.UserinfoService;
import service.serviceImpl.UserinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName=request.getParameter("uname");
        String loginPass=request.getParameter("upass");
        UserinfoService userinfoService=new UserinfoServiceImpl();
        Userinfo userinfo=userinfoService.getUserinfoName(loginName);
        HttpSession session=request.getSession();
        if (userinfo!=null){
            if (userinfo.getLoginPass().equals(loginPass)){
                response.sendRedirect("index.jsp");
                session.setAttribute("uname",userinfo.getRealname());
                session.setAttribute("user",userinfo);
            }
            else {
                response.sendRedirect("login.html");
            }
        }else {
            response.sendRedirect("login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
