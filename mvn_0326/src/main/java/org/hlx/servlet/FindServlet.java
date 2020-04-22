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
import java.util.List;

@WebServlet(name = "FindServlet",urlPatterns = "/find")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

        //具体操作///////////////////

       String strID = request.getParameter("id");
        //封装

        //业务对象
        UsersService service = new UsersServiceImpl();

        //调用方法
        Users   user = service.getUsers(Integer.parseInt(strID));

        //保存
        request.setAttribute("user" ,user);

        //跳转
        request.getRequestDispatcher("userinfo.jsp").forward(request,response);

        ///////////////////////////////////////
        out.println();
        //关闭
        out.flush();
        out.close();
    }
}
