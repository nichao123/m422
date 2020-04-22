package mvn_0331.src.main.java.org.hlx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@WebServlet(name = "MyServlet",urlPatterns = "*.action")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //具体操作
        //获得提交路径  /save.action
        String path = request.getServletPath();
//        out.println(path);
        //截取文件名 save
        String fileName =path.substring(1,path.lastIndexOf("."));
//        out.println(fileName);
        try {
            //利用反射机制
            Method method =this.getClass().getDeclaredMethod(fileName,HttpServletRequest.class,HttpServletResponse.class);
            //调用
            method.invoke(this,request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();
        //////////////
        out.println("add !");
        //关闭
        out.flush();
        out.close();
    }


    /**
     * 更新
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();
        //////////////
        out.println("update !");
        //关闭
        out.flush();
        out.close();
    }


    /**
     * 删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();
        //////////////
        out.println("del !");
        //关闭
        out.flush();
        out.close();
    }
}
