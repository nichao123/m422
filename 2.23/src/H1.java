public class H1 {
    public static void main(String[] args) {
        MyRunable mr = new MyRunable();
        Thread th1 = new Thread(mr, "main");
        Thread th2 = new Thread(mr, "Thread-0");


        th1.start();

        th2.start();

        System.out.println("********显示默认优先级********");
        System.out.println("主线程名：" + th1.getName() + ",优先级：" + th1.getPriority());
        System.out.println("子线程名:" + th2.getName() + ",优先级：" + th2.getPriority());
        th1.setPriority(Thread.MAX_PRIORITY);
        th2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("********修改默认优先级后********");
        System.out.println("主线程名：" + th1.getName() + ",优先级：" + th1.getPriority());
        System.out.println("子线程名:" + th2.getName() + ",优先级：" + th2.getPriority());
    }
}

class MyRunable implements Runnable {
    //重写方法
    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
//            System.out.print(Thread.currentThread().getName()+"，优先级：");


        }
    }
}