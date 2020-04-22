package servlet;

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
        String uname=request.getParameter("uname");
        String upwd=request.getParameter("upwd");
        String usex=request.getParameter("usex");
        String ubirth=request.getParameter("ubirth");
        String utel=request.getParameter("utel");
        String uadd=request.getParameter("uadd");


        int count=userinfoService.updateUserinfo(new Userinfo(uname,upwd,usex,ubirth,utel,uadd));

        if (count==1){
            response.sendRedirect("login.html");
        }
        else {
            response.sendRedirect("userView.html");
        };
    }
}
