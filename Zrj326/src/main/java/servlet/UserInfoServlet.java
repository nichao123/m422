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

@WebServlet(name = "UserInfoServlet",urlPatterns = "/userinfo")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserinfoService userinfoService=new UserinfoServiceImpl();
        String loginName=request.getParameter("loginName");
        String realName=request.getParameter("realName");
        String loginPass=request.getParameter("loginPass");
        String phone=request.getParameter("phone");
        System.out.println(loginName);
        int count=userinfoService.updateUserinfo(new Userinfo(loginName,loginPass,phone,realName));
        System.out.println(count);
        if (count==1){
            response.sendRedirect("login.html");
        }
        else {
            response.sendRedirect("userinfo.jsp");
        };
    }
}
