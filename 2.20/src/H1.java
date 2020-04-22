public class H1 {
    //需求说明:继承Thread类的方式创建线程
    //创建两个子线程，每个线程均输出20次消息数字、“你好”、线程名
    //观察多个线程交替执行的过程
    public static void main(String[] args) {
        My my = new My();
        my.start();
        My my2 = new My();
        my2.start();
    }
}

class My extends Thread {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i+1 + ".你好，来自线程" + Thread.currentThread().getName());
        }
    }
}
