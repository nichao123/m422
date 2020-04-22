package Zrj326.src.main.java.servlet;

import pojo.Userinfo;
import service.UserinfoService;
import service.serviceImpl.UserinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RechargeableServlet",urlPatterns = "/rechargeable")
public class RechargeableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName=request.getParameter("loginname");
        UserinfoService userinfoService=new UserinfoServiceImpl();
        Userinfo userinfo=userinfoService.getUserinfoName(loginName);
        if (userinfo!=null){
            request.setAttribute("user",userinfo);
            request.getRequestDispatcher("rechargeable.jsp").forward(request,response);
        }
    }
}
