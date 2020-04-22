package javaoop_0226.src.lesson.org.hlx;

/**
 * @ClassName TestXML
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/26
 * @Version V1.0
 **/
public class TestXML {

    public static void main(String[] args) {
        StudentBiz biz =new StudentBiz();
        biz.show();

        Student stu1=new Student("懒洋洋","21",18);
//        biz.add(stu1);

//        biz.del("21");

        Student stu2=new Student("大飞猫","05",5);
        biz.update(stu2);

        biz.show();


    }
}
