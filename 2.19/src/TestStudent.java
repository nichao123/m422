import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestStudent {
    public static void main(String[] args) {
        StudentBiz sb=new StudentBiz();
        File file=new File("student.txt");
        more(sb,file);
    }
    private static void more(StudentBiz sb,File file){
        if (!file.exists()){
            System.out.println("序列化");
            Student stu1=new Student(1,"hh","男");
            Student stu2=new Student(3,"aa","女");
            Student stu3=new Student(2,"cc","男");
            List<Student> list=new ArrayList<Student>();
            list.add(stu1);
            list.add(stu2);
            list.add(stu3);
            sb.serializable(file,list);
        }else {
            System.out.println("反序列化");
            List<Student> list2= (List<Student>) sb.deSerializable(file);
            for (Student stu:
                    list2 ) {
                System.out.println(stu);
            }
        }
    }


}
 class StudentBiz {
    //序列化
    public void serializable(File file, List<Student> students) {
        //输出文件流
        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {  //对象输出流

            //写入
            oos.writeObject(students);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //反序列化
    public Object deSerializable(File file) {

        //输入流对象
        try (InputStream is = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(is)  //对象输入流
        ) {
            //读取
            return ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
