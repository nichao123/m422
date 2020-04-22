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
import java.util.List;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName=request.getParameter("uname");
        String loginpass=request.getParameter("pass1");
        String loginpass2=request.getParameter("pass2");
        String phone=request.getParameter("tel");
        String realname=request.getParameter("realname");
        Userinfo userinfo=new Userinfo(loginName,loginpass,phone,realname);
        UserinfoService userinfoService=new UserinfoServiceImpl();
            if (userinfo.getLoginName()!=null && !userinfo.getLoginName().equals("") && loginpass==loginpass2){
                if (userinfoService.getUserinfoName(userinfo.getLoginName())==null) {
                    userinfoService.addUserinfo(userinfo);
                    response.sendRedirect("login.html");
                    return;
                }
            }
            response.sendRedirect("register.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
