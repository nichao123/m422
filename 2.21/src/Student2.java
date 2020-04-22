public class Student2 implements Comparable<Student2> {
    private String name;//姓名
    private int math;
    private int chinese;
    private int english;
    private int zong;

    public Student2() {
    }

    public Student2(String name, int math, int chinese, int english, int zong) {
        this.name = name;
        this.math = math;
        this.chinese = chinese;
        this.english = english;
        this.zong = zong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getZong() {
        return zong;
    }

    public void setZong(int zong) {
        this.zong = zong;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", math=" + math +
                ", chinese=" + chinese +
                ", english=" + english +

                '}';
    }

    @Override
    public int compareTo(Student2 o) {
        return o.zong-this.zong;
    }
}
