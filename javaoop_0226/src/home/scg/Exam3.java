package javaoop_0226.src.home.scg;

public class Exam3 {

    private int MAX_SIZE;//仓库的最大容量
    private int count;//当前的货物数量
    private int sum; //生产的总数


    public Exam3(int n) {//初始化最大容量的构造方法
        MAX_SIZE = n;
        count = 0;
        sum = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    //往仓库加货物的方法
    public synchronized void add() {
        while (count >= MAX_SIZE) {//每次执行都判断仓库是否已满
            System.out.println("满了");
            try {
                this.wait();//如果满了，就进入等待池
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        count++;//数量加1
        sum++;
        //打印当前仓库的货物数量
        System.out.println(Thread.currentThread().getName() + "编号" + count + "电视机，当前库存数：" + count);
        //仓库中已经有东西可以取了，则通知所有的消费者线程来拿
        this.notifyAll();
    }

    //从仓库拿走货物的方法
    public synchronized void remove() {
        while (count <= 0) {
            System.out.println("空了");//每次执行都判断仓库是否为空
            try {
                this.wait();//如果为空，就进入等待池
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        count--;//数量减1
        //打印当前仓库的货物数量
        System.out.println(Thread.currentThread().getName() + "编号" + (count + 1) + "电视机，当前库存数：" + count);
        //仓库还没装满，通知生产者添加货物
        this.notifyAll();
    }

    public static void main(String[] args) {
//        容量大小对象
        Exam3 exam3 = new Exam3(5);

//        线程对象
        Thread th1 = new Thread1(exam3);
        Thread th2 = new Thread2(exam3);

//        改名
        th1.setName("生产");
        th2.setName("消费");

//        启动
        th1.start();
        th2.start();
    }
}

class Thread1 extends Thread {
    private Exam3 exam3;

    public Thread1(Exam3 exam3) {
        this.exam3 = exam3;
    }

    //    重写run
    @Override
    public void run() {
        while (exam3.getSum() != 10) {
            exam3.add();  //加货物
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 extends Thread {
    private Exam3 exam3;

    public Thread2(Exam3 exam3) {
        this.exam3 = exam3;
    }

    //    重写run
    @Override
    public void run() {
        do {
            exam3.remove();  //取货物
//        休眠
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (exam3.getSum() != 10);
    }
}
