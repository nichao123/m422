import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Shangji2 {
    public static void main(String[] args) {
        String[] strs=null;
        Scanner scanner=new Scanner(System.in);
        ArrayList<Student2> arr=new ArrayList<Student2>();
        while (true){
            System.out.println("请输入字符格式：mike,80,45,20  输入exit退出");
            String str=scanner.nextLine();
            if (str.equals("exit")){
                break;
            }else {
                 strs=str.split(",");
                Student2 stu=new Student2(strs[0],Integer.parseInt(strs[1]),Integer.parseInt(strs[2]),Integer.parseInt(strs[3]),Integer.parseInt(strs[1])+Integer.parseInt(strs[2])+Integer.parseInt(strs[3]));
                arr.add(stu);

            }
        }
        Collections.sort(arr);
//        for (Student2 ss:
//             arr) {
//            System.out.println(ss);
//        }

        BufferedWriter bw=null;
        try {
            File file=new File("student666.txt");
            FileWriter fw=new FileWriter(file);
             bw=new BufferedWriter(fw);
           bw.newLine();

            for (Student2 st:
                    arr) {
                String stu=st.toString()+st.getZong()+"\n";
                bw.write(stu);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
