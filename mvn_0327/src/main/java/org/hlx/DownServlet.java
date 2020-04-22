package mvn_0327.src.main.java.org.hlx;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

@javax.servlet.annotation.WebServlet(name = "DownServlet", urlPatterns = "/down")
public class DownServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");

        //获取文件名
        String fileName = request.getParameter("name");

        //获取服务器路径
//        String path = request.getServletContext().getRealPath("/upload");
         String path = "C:\\Users\\44401\\OneDrive\\桌面\\images\\2.png";

        //完整路径
//        String allPath = path+"\\"+fileName;

        System.out.println(path);

        //文件流操作
        FileInputStream fis = new FileInputStream(path);
        //响应头信息，编码
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+fileName);
        //servlet 输出流对象
        ServletOutputStream out = response.getOutputStream();

        byte[] bt = new byte[1024];
        int length = 0;
        while((length=fis.read(bt))!=-1){
            out.write(bt,0,length);
        }
        out.close();
        fis.close();



        ///////////////////////////////

    }
}
