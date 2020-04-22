import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lianxi {
    public static void main(String[] args) {
        File file=new File("/myDoc");
        File file2=null;
        file.mkdirs();
        //)判断是否是文件
        if (file.isFile()){
            System.out.println("yes file");
        }else {
            //判断是否是目录
            if (file.isDirectory()){

                //是目录创建空文件;
                try {
                    file2 = new File("/myDoc/test.txt");
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
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream("/myDoc/test.txt",true);
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
        //查看文件名
        System.out.println("名称："+file2.getName());

        //查看文件的相对路径
        System.out.println("相对路径："+file2.getPath());

        //查看文件的绝对路径
        System.out.println("绝对路径："+file2.getAbsolutePath());
        //查看文件大小
        System.out.println("文件大小："+file2.length() + " 字节");
    }
}
