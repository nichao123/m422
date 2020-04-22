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
import java.util.List;

@WebServlet(name = "AllServlet",urlPatterns = "/all")
public class AllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

        //具体操作///////////////////


        //封装

        //业务对象
        UsersService service = new UsersServiceImpl();

        //调用方法
        List<Users>   list = service.all("");

        //保存
        request.setAttribute("list" ,list);

        //跳转
        request.getRequestDispatcher("listUsers.jsp").forward(request,response);

        ///////////////////////////////////////
        out.println();
        //关闭
        out.flush();
        out.close();
    }
}
