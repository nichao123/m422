import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Shangji2 {
    public static void main(String[] args) {
        String[] strs=null;
        Scanner scanner=new Scanner(System.in);
        ArrayList<Student2> arr=new ArrayList<Student2>();
        while (true){
            System.out.println("请输入学生信息：（学号#姓名#年龄）");
            String str=scanner.nextLine();
            if (str.equals("exits")){
                break;
            }else {
                strs=str.split("#");
                Student2 stu=new Student2(strs[0],strs[1],Integer.parseInt(strs[2]));
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
            File file=new File("student333.txt");
            FileWriter fw=new FileWriter(file);
             bw=new BufferedWriter(fw);
           bw.newLine();

            for (Student2 st:
                    arr) {
                String stu=st.toString()+Integer.parseInt(strs[2])+"\n";
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
