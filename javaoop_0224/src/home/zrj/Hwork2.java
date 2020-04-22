package javaoop_0224.src.home.zrj;

public class Hwork2 {
    public static void main(String[] args) {
//        练习2：模拟叫号看病
//                需求说明
//        某科室一天需看普通号50个，
//        特需号10个特需号看病时间是普通号的2倍
//        开始时普通号和特需号并行叫号，
//        叫到特需号的概率比普通号高
//        当普通号叫完第10号时，
//        要求先看完全部特需号，
//        再看普通号使用多线程模拟这一过程
//        创建线程
//        普通号50个看病时间0.5S
//        特需号10个看病时间1S
        TextT1 tt2=new TextT1(10,1000);
        Thread putong=new Thread("普通号");
        Thread texu=new Thread(tt2,"特需号");
        texu.start();
        for (int i = 0; i < 50; i++) {
            System.out.println(putong.getName()+"："+(i+1)+"号病人正在看病！");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i==9){
                try {
                    texu.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
//定义线程
class TextT1 implements  Runnable{
//    病号个数
    private int num;
//    看病时间
    private long time;
//    封装
    public TextT1(int num, long time) {
        this.num = num;
        this.time = time;
    }
    public TextT1() {
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    @Override
    public void run() {
        for (int i=0; i < num;i++) {
            System.out.println(Thread.currentThread().getName()+"："+(i+1)+"号病人正在看病！");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
