package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "LoginServlet",urlPatterns = "/login")
@WebServlet(name = "LoginServlet",urlPatterns = {"/login.do","/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//          doGet(request,response);
        login(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getData(request, response);

    }


    private void getData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

         out.println("*,do...");

        //关闭
        out.flush();
        out.close();
    }


    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

        //
        String name =request.getParameter("name");
        String pass =request.getParameter("pass");

        //判断
        if("米克".equals(name) && "aaa".equals(pass)){
            out.println("login oK!"+name);
        }else{
            out.println("login  NO"+name);
        }

        //关闭
        out.flush();
        out.close();
    }


}
