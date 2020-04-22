package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DestroyServlet",urlPatterns = "/ds")
public class DestroyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          System.out.println("DestroyServlet doGet!!");
          getDestroy(request, response);

    }


    private void getDestroy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

        //具体操作
        HttpSession session = request.getSession();

        //移除属性
        session.removeAttribute("uname");

        //销毁
        session.invalidate();

        //跳转 (首页或登录页面)
        response.sendRedirect("show.html");

        out.println();
        //关闭
        out.flush();
        out.close();
    }


}
