package org.nichao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    public HelloServlet() {
        System.out.println("加载并实例化对象");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String str=this.getInitParameter("count");

        out.println(str+"<p/>");
        out.flush();
        out.close();
    }
}
