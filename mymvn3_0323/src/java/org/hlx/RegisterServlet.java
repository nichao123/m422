package org.hlx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",urlPatterns = "/reg")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.响应编码
        response.setContentType("text/html;charset=utf-8");

        //2.输出对象
        PrintWriter out = response.getWriter();

/////////////////////////////////////////
        //中文处理
        request.setCharacterEncoding("utf-8");

        //表单提交的数据
         String name =request.getParameter("name");
         String pass =request.getParameter("pass");

        //输出信息
        out.println(name+"<p/>");
        out.println(pass+"<p/>");


        //除了复选框，用这个方法；
         String[] nows =request.getParameterValues("now");
        for (String now :
           nows ) {
            out.println(now+"&nbsp;");
        }
       ////////////////////////////////
//           进行跳转
        //转发(间接跳转)
//        request.getRequestDispatcher("index.jsp").forward(request,response);
//        request.getRequestDispatcher("show").forward(request,response);

          //通过参数跳转
//           response.sendRedirect("show?uname="+name+"&upass="+pass);


        //保存数据

        //获得会话对象
        HttpSession  session = request.getSession();

        //保存 key=value
        session.setAttribute("uname",name);
        session.setAttribute("upass",pass);


        //最后跳转
        response.sendRedirect("show");


        //3.关闭对象
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
