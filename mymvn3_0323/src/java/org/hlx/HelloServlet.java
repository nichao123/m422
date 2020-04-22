package org.hlx;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 表单提交方式: get/post
 *  默认是get方式!!
 */
public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("加载并实例化对象！");
    }

    @Override
    public void destroy() {
        System.out.println("火花！");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("抬上山！");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理doPost!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        System.out.println("处理doGet!");

        //1.响应编码
        response.setContentType("text/html;charset=utf-8");

        //2.输出对象
        PrintWriter out = response.getWriter();

        //获取初始化参数
        String str = this.getInitParameter("count");
        String str2 = this.getInitParameter("uname");

        //输出信息
        out.println(str+"<p/>");
        out.println(str2+"<p/>");



        //3.关闭对象
        out.flush();
        out.close();


    }
}
