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

@WebServlet(name = "RechargeableDoServlet",urlPatterns = "/rechargeabledo")
public class RechargeableDoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName=request.getParameter("loginname");
        UserinfoService userinfoService=new UserinfoServiceImpl();
        Userinfo userinfo=userinfoService.getUserinfoName(loginName);
        int money=Integer.parseInt(request.getParameter("amount"));
        userinfo.setAmount(userinfo.getAmount()+money);
        System.out.println(userinfo.getAmount());
        userinfoService.setAmount(userinfo);
        response.sendRedirect("rechargeable.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
