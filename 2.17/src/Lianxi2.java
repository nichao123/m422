import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Lianxi2 {
    public static void main(String[] args) {
        File file=new File("d:/jar");
        file.mkdirs();
        File file2=null;
        //)判断是否是文件
        if (file.isFile()){
            System.out.println("yes file");
        }else {
            //判断是否是目录
            if (file.isDirectory()){

                //是目录创建空文件;
                try {
                    file2 = new File("d:/jar/dom4j-1.6.1_2.jar");
                    //能否创建空文件
                    file2.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("no Directory!");
                //能否创建单个目录?
                file.mkdir();

            }
        }
        //添加数据
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream("d:/jar/dom4j-1.6.1_2.jar",true);
            fos.write("afasfafafa".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("当前文件夹是："+file2);
        System.out.println("判断是否存在："+file2.exists());
        System.out.println("判断是否是文件夹："+file2.isDirectory());
        System.out.println("判断是否是文件："+file2.isFile());
        System.out.println("获取文件的长度"+file2.length());
        long time = file2.lastModified();
        Date d = new Date(time);
        System.out.println("获取文件的最后修改时间："+d);
        //重新命名此抽象路径名表示的文件
        File dest=new File("DOM4j.jar");
        file2.renameTo(dest);
        System.out.println("把dom4j-1.6.1_2.jar改名成了"+dest);


    }
}
