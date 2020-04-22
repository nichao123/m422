package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//注解方式  (不需要web.xml配置文件)
//@WebInitParam(name="addr",value = "杭州市")
@WebServlet(name = "MyServlet",urlPatterns ="/my",initParams ={@WebInitParam(name="addr",value = "杭州市")} )
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.响应编码
        response.setContentType("text/html;charset=utf-8");

          //2.输出对象
        PrintWriter out = response.getWriter();

        //参数
        String str= this.getInitParameter("addr");

        //输出信息
        out.println("this is a test !<p/>");
        out.println("张撒！!<p/>");
        out.println(str+"<p/>");


        //3.关闭对象
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 直接调用
        doPost(request,response);
    }
}
