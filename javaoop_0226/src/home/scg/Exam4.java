package javaoop_0226.src.home.scg;

public class Exam4 {
    public static void main(String[] args) {
//        线程对象
        School school = new School();
//        启动
        school.teacher.start();
        school.stu1.start();
        school.stu2.start();

    }
}


class School implements Runnable {
    //线程对象
    Thread teacher, stu1, stu2;

//    初始化
    public School() {
        teacher = new Thread(this, "吉吉国王");
        stu1 = new Thread(this, "大白熊");
        stu2 = new Thread(this, "翠花");
    }

    //    重写run
    @Override
    public void run() {
        //判断当前线程是什么
        if (Thread.currentThread() == teacher) {
            System.out.println("老师线程=>" + Thread.currentThread().getName());
//        循环
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + "  说上课了！");
            }
//            中断大白熊
            stu1.interrupt();
        } else if (Thread.currentThread() == stu1) {
            System.out.println("学生线程=>" + Thread.currentThread().getName());
            //1分钟
            try {
                Thread.sleep(1000*60*60);
            } catch (InterruptedException e) { //中断异常
//                e.printStackTrace();
                stu2.interrupt();  //中断翠花
                System.out.println("学生线程【" + Thread.currentThread().getName() + "】唤醒");

            }
        } else if (Thread.currentThread() == stu2) {
            System.out.println("学生线程=>" + Thread.currentThread().getName());
            //5分钟
            try {
                Thread.sleep(5000*60*60);
            } catch (InterruptedException e) { //中断异常
//                e.printStackTrace();
                System.out.println("学生线程【" + Thread.currentThread().getName() + "】唤醒");

            }
        }

    }

}

