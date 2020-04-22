package org.hlx;

import org.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyDestroyServlet", urlPatterns = "/myclose")
public class MyDestroyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();


        //保存到会话中
        HttpSession session = request.getSession();
        //保存的是对象
        session.removeAttribute("user");
        session.invalidate();

        //跳转
        response.sendRedirect("jsp/login.jsp");

        //关闭
        out.flush();
        out.close();
    }
}
