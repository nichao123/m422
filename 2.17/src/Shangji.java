import java.io.*;

public class Shangji {
    public static void main(String[] args) {
        //创建目录
        File file=new File("d:");
        file.mkdirs();
        File file2=null;
        File file3=new File("c:/myFile");
        file3.mkdirs();
        File file4=null;
        //)判断是否是文件
        if (file.isFile()){
            System.out.println("yes file");
        }else {
            //判断是否是目录
            if (file.isDirectory()){

                //是目录创建空文件;
                try {
                    file2 = new File("d:/我的青春谁做主.txt");
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

        //创建c:/myFile/myPrime.txt文件
        if (file3.isFile()){
            System.out.println("yes file");
        }else {
            //判断是否是目录
            if (file.isDirectory()){

                //是目录创建空文件;
                try {
                    file4 = new File("c:/myFile/myPrime.txt");
                    //能否创建空文件
                    file4.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("no Directory!");
                //能否创建单个目录?
                file3.mkdir();

            }
        }
        //添加数据
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream("d:/我的青春谁做主.txt",true);
            fos.write("hello".getBytes());
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
        ////文件的复制
        //自动关闭流
        try(FileInputStream fis =new FileInputStream("d:/我的青春谁做主.txt");
            FileOutputStream fos2 = new FileOutputStream("c:/myFile/myPrime.txt")
        ){
            int len=0;

            //中转站
            byte[] bytes =new byte[5];

            //循环读取
            while((len=fis.read(bytes,0,bytes.length))!=-1){
                //写入
                fos2.write(bytes,0,bytes.length);
            }
            System.out.println("OK!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
