package javaoop_0226.src.home.da.home1_3;

/**
 * @ClassName Test3
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/23
 * @Version V1.0
 **/
public class Test3 {
    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        TeacherThread teacher = new TeacherThread("吉吉国王");
        Stu1Thread stu1 = new Stu1Thread("大白熊");
        Stu1Thread stu2 = new Stu1Thread("翠花");

        try {
            stu1.sleep(1 * 1000);
            stu2.sleep(5 * 1000);
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        teacher.start();
        stu1.start();
        stu2.start();

    }

}

/**
 * 老师线程
 */
class TeacherThread extends Thread {
    //构造方法
    public TeacherThread(String name) {
        super(name);
        System.out.println("老师线程=>"+name);
    }

    public void run() {
        for (int i = 0; i < 4; i++)
            System.out.println(this.getName() +"  说上课了！");

    }

}

/**
 * 学生线程
 */
class Stu1Thread extends Thread {
    public Stu1Thread(String name){
       super(name);
        System.out.println("学生线程=>"+name);
    }

    @Override
    public void run() {
        System.out.println("学生线程【" + this.getName() + "】唤醒");
    }

}


