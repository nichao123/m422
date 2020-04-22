package javaoop_0224.src.home.weekhome.xcy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Work {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 保存学生信息的TreeSet集合对象
        Set<Student> stuSet = new TreeSet<Student>();
        System.out.println("请输入学生信息:(姓名，成绩1，成绩2，成绩3)");
        while (true) {
            // 输入提示

            String inputData = input.nextLine();
            // 判断是否退出 inputData.equals("exit")
            if ("exit".equals(inputData)) {
                break;
            }
            // 将用户输入的学生信息分割为String[]
            String[] info = inputData.split(",");
            // 将输入信息封装到Student对象中
            Integer count = Integer.parseInt(info[1]) + Integer.parseInt(info[2]) + Integer.parseInt(info[3]);
            Student stu = new Student(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]), count);
            // 将学生对象加入集合
            stuSet.add(stu);
        }


        File file = new File("homework1.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            Iterator<Student> it = stuSet.iterator();
            while (it.hasNext()) {
                String info = it.next().toString();
                fw.write(info);
                fw.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


class Student implements Comparable<Student> {
    private String name;
    private Integer score1;
    private Integer score2;
    private Integer score3;
    private Integer count;

    public Student(String name, Integer score1, Integer score2, Integer score3, Integer count) {
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.count = count;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public Integer getScore3() {
        return score3;
    }

    public void setScore3(Integer score3) {
        this.score3 = score3;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", score3=" + score3 +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return o.getCount() - this.getCount();
    }
}