import java.io.*;

public class Shangji1 {
    //音乐位于d盘根目录下，要求将此音乐复制到c盘下
    public static void main(String[] args) {

        try( //二进制文件读取对象
             FileInputStream fis =new FileInputStream("d://上海滩.mp3");
             DataInputStream dis =new DataInputStream(fis);
             //二进制文件写入对象
             FileOutputStream fos =new FileOutputStream("g://上海滩.mp3");
             DataOutputStream dos =new DataOutputStream(fos)

        ) {

            //批量读取
            byte[] bys= new byte[1024];

            //循环读取，再写入
            while((dis.read(bys))!=-1){
                dos.write(bys,0,bys.length);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
