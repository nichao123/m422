package javaoop_0226.src.lesson.org.hlx;

/**
 * @ClassName Student
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/26
 * @Version V1.0
 **/
public class Student {
    private String name;
    private String sn;
    private int age;

    public Student(String name, String sn, int age) {
        this.name = name;
        this.sn = sn;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  sn + "\t" + name + "\t"+ age ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
