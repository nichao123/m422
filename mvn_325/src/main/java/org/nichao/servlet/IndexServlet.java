package org.nichao.servlet;

import org.nichao.pojo.Users;
import org.nichao.service.UsersService;
import org.nichao.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

        //具体操作///////////////////
        String name = request.getParameter("userName");
        String pass = request.getParameter("userPass");

        //封装
        Users user=new Users(name,pass);

        //业务对象
        UsersService service = new UsersServiceImpl();

        //调用方法
        int count=service.isLogin(user);

        //判断
        if(count>0){
         response.sendRedirect("welcome.html");
        }else{
            response.sendRedirect("index.html");
        }

        ///////////////////////////////////////
        out.println();
        //关闭
        out.flush();
        out.close();
    }
}
