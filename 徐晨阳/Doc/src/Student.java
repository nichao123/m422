package 徐晨阳.Doc.src;

import java.util.Scanner;

public class Student {
    //三、设计一个学生类Student，
    // 包括no(学号)、name(姓名)和score(成绩)数据成员，
    // show()方法用于输出数据成员的值，
    // 求输入5个学生的数据计算平均分avg()方法。在main()方法中定义了一个对象数组用于存储输入的学生数据。


    //创建学生类
    public int no;
    public String name;
    public int score;


    //tostring
    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


    //重载构造方法
    Student(int no, String name, int score) {
        this.no = no;
        this.name = name;
        this.score = score;
    }


}

//
class StudentBiz {

    //创建一个对象的数组


    //添加一个学生
    public void add(Student[] students, Student stu) {

        //循环
        for (int i = 0; i < students.length; i++) {

            //判断
            if (students[i] == null) {
                students[i] = stu;  //添加
                break;
            }
        }

    }


    //计算平均分
    public void avg(Student[] students) {
        //初始化
        double scoreavg = 0;

        //循环
        for (Student stux : students
        ) {
            //判断，有一说一，这个可以不用判断
            if (stux != null) {
                scoreavg += stux.score;
            }
        }

        //计算平均分
        scoreavg = scoreavg / students.length;
        //输出
        System.out.println("平均成绩为：" + scoreavg);
    }

    //show方法
    public void show(Student[] students) {
        //循环
        for (Student stu : students
        ) {
            //判断
            if (stu != null) {
                System.out.println("学号：" + stu.no + "\t姓名：" + stu.name + "\t成绩：" + stu.score);
            }
        }
    }
}


class TestStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //整个数组用来塞数据
        Student student[] = new Student[2];

        //因为数组不能直接往里头？我不晓得，我反正定义三个数据，然后把它们放进这个对象数组中。
        String name;
        int no;
        int score;
        StudentBiz studentBiz = new StudentBiz();
        for (int i = 0; i < student.length; i++) {
            System.out.print("学号");
            no = scanner.nextInt();

            System.out.print("姓名");
            name = scanner.next();

            System.out.print("成绩");
            score = scanner.nextInt();
            //塞进去
            Student stu = new Student(no, name, score);
            //调用Biz的方法，把他添加到Biz的数组中
            studentBiz.add(student,stu);
        }
        //输出
        studentBiz.show(student);
        //算平均分
        studentBiz.avg(student);

    }
}