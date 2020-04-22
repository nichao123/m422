public class H2 {
    public static void main(String[] args) {
        MyRunnable mr=new MyRunnable();
        Thread t1=new Thread(mr);
        Thread t2=new Thread(mr);
        t1.start();
        t2.start();
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i+1 + ".你好，来自线程" + Thread.currentThread().getName());
        }
    }
}