public class H4 {
    public static void main(String[] args) {
        System.out.println("老师线程=>吉吉国王");
        System.out.println("学生线程=>大白熊");
        System.out.println("学生线程=>翠花");
        final Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("吉吉国王  说上课了！");
                System.out.println("吉吉国王  说上课了！");
                System.out.println("吉吉国王  说上课了！");
                System.out.println("吉吉国王  说上课了！");
            }
        });
        final Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("学生线程【大白熊】唤醒");
            }
        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("学生线程【翠花】唤醒");
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }
}
