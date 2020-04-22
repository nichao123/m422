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

@WebServlet(name = "listUsersServlet", urlPatterns = "/listUsers")
public class listUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

        //具体操作///////////////////
        String id = request.getParameter("userId");
        String name = request.getParameter("userName");
        String pass = request.getParameter("password");

        //获得按钮值
        String submit = request.getParameter("Submit");

        //封装
        Users user = new Users(Integer.parseInt(id), name, pass);

        //业务对象
        UsersService service = new UsersServiceImpl();

        int count = 0;

        //判断按钮
        if ("修改".equals(submit)) {
            //调用方法
            count = service.updateUsers(user);
        } else {
            //调用方法
            count = service.delUsers(Integer.parseInt(id));
        }


        //判断
        if (count > 0) {
            response.sendRedirect("all");  //查询数据
        } else {
            response.sendRedirect("userinfo.jsp");
        }

        ///////////////////////////////////////
        out.println();
        //关闭
        out.flush();
        out.close();
    }
}
