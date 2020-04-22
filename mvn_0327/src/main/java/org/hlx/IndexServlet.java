package mvn_0327.src.main.java.org.hlx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends javax.servlet.http.HttpServlet {
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



        String name = request.getParameter("name");


        //用户列表
        List<String> list = Arrays.asList("杨勇", "mike", "armand", "飞扬");

        for (String str :
                list) {
            if (str.equals(name)) {
                count = 1;
                break;
            }
        }
        ///////////////////////////////////////
        //响应到前端的数据
        out.println(count);

        //关闭
        out.flush();
        out.close();
    }
}
