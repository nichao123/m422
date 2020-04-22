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

@WebServlet(name = "UserAllServlet",urlPatterns = "/userAll")
public class UserAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserinfoService userinfoService=new UserinfoServiceImpl();
        List<Userinfo> list=userinfoService.all("");
        request.setAttribute("userlist",list);
        request.getRequestDispatcher("userAll.jsp").forward(request,response);
    }
}
