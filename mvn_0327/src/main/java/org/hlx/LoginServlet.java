package mvn_0327.src.main.java.org.hlx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

        //具体操作///////////////////
        int count = 0;   //标记

        //序列的数据
        //根据名称取数据：<input type="text" name="name" id="name"/>
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if ("mike".equals(name) && "aaa".equals(pass)) {
            //响应到前端的数据
            out.println(1);
        } else if ("张三".equals(name) && "123".equals(pass)) {
            //响应到前端的数据
            out.println(1);
        } else {
            //响应到前端的数据
            out.println(0);
        }

        //关闭
        out.flush();
        out.close();
    }
}
