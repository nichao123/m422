package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowServlet",urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.响应编码
        response.setContentType("text/html;charset=utf-8");

        //2.输出对象
        PrintWriter out = response.getWriter();

        //1>转发获得数据
//        String name = request.getParameter("name");

        //2>重定向获得数据
//        String name = request.getParameter("uname");
//        String pass = request.getParameter("upass");
//
//        out.println("欢迎你！！！！<h1>"+name+"</h1>");
//        out.println(pass);



        //3>会话保存的数据
        //获得会话对象
        HttpSession session = request.getSession();
        //获得数据是对象=>强制类型转换
        String name = (String) session.getAttribute("uname");
        String pass = (String) session.getAttribute("upass");


        out.println("欢迎你！！！！<h1>"+name+"</h1>");
        out.println(pass);


        //输出信息

        //3.关闭对象
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
