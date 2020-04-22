package mvn_0327.src.main.java.org.hlx;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

@javax.servlet.annotation.WebServlet(name = "UploadServlet", urlPatterns = "/up")
@MultipartConfig //使用MultipartConfig注解标注改servlet能够接受文件上传的请求
public class UploadServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter out = response.getWriter();

//        //获得Part实例多个集合
//        Collection<Part> parts= request.getParts();
//        //遍历
//        while(Iterator<Part> it=parts.iterator(); it.hasNext()){
//            //   获得Part实例
//            Part part=  it.next();
//        }

        ////////////////////////////////
        //1.获得Part实例      <input type="file" name="myfile">
        Part  part =request.getPart("myfile");

        //2.获得文件头信息
        String desc = part.getHeader("Content-Disposition");
       // out.println(desc);
//        form-data; name="myfile"; filename="1.jpg"

         //3.截取文件名的后缀 .jpg, .pgn
        String after=desc.substring(desc.lastIndexOf("."),desc.length()-1);
//        out.println(after+"<p/>");

        //4. 随机的生存一个32的字符串
        String fileName = UUID.randomUUID()+after;

        //5.动态获取服务器的路径
        String path = request.getServletContext().getRealPath("/upload");
        //判断是否有这个
        File file =new File(path);
        if(!file.exists()){
            file.mkdirs();  //创建目录
        }

        //完整路径
        String allPath = file+"/"+fileName;
        out.println(allPath+"<p/>");

        //文件流操作
        //6获取上传的输入流
        InputStream is = part.getInputStream();
        //输出流对象
        FileOutputStream fos = new FileOutputStream(allPath);

        //批量存储1024字节
        byte[] bty = new byte[1024];
        int length =0;
        //循环读取
        while((length=is.read(bty))!=-1){
            fos.write(bty,0,length);   //写入
        }

        //关闭
        is.close();
        fos.close();



        ///////////////////////////////

    }
}
