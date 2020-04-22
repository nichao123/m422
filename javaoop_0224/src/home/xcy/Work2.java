package javaoop_0224.src.home.xcy;

public class Work2 {
    public static void main(String[] args) {
        Runnre5 r1 = new Runnre5(10, "特殊号", 500);
        Runnre5 r2 = new Runnre5(50, "普通号", 250);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}

class Runnre5 implements Runnable {
    private int num;
    private String name;
    private int time;

    public Runnre5(int num, String name, int time) {
        this.num = num;
        this.name = name;
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    @Override
    public void run() {
        for (int i = 1; i <= this.num; i++) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
            }
            System.out.println(this.name + ":" + i + "病人在看病");
            if (this.name.equals("普通号") && i == 10) {
                try {
                    Thread.currentThread().join(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}