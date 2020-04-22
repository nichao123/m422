package org.hlx.servlet;

import org.hlx.pojo.Users;
import org.hlx.service.UsersService;
import org.hlx.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddUserServlet",urlPatterns = "/addUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

        //具体操作///////////////////
        String name = request.getParameter("textfield");
        String pass = request.getParameter("textfield2");

        //封装
        Users user=new Users(name,pass);

        //业务对象
        UsersService service = new UsersServiceImpl();

        //调用方法
        int count=service.addUsers(user);

        //判断
        if(count>0){
         response.sendRedirect("index.html");
        }else{
            response.sendRedirect("addUser.html");
        }

        ///////////////////////////////////////
        out.println();
        //关闭
        out.flush();
        out.close();
    }
}
