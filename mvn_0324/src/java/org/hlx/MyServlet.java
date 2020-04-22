package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet",urlPatterns = "/my")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getSession(request, response);

    }



    private void getSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

        //具体操作
        HttpSession session = request.getSession();

        //了解
        System.out.println("id=>"+session.getId());
        System.out.println("max=>"+session.getMaxInactiveInterval());
        System.out.println("lastTime=>"+session.getLastAccessedTime());

        //保存
        session.setAttribute("uname","Ellen");

        //设置周期  5分=300秒  (自动到5分钟就结束！！！)
        session.setMaxInactiveInterval(300);

        //跳转
        response.sendRedirect("index.jsp");

        out.println();
        //关闭
        out.flush();
        out.close();
    }
}
