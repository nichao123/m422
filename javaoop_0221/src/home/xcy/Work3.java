package javaoop_0221.src.home.xcy;

public class Work3 {
    //需求说明
    //每个线程代表一个人可设置每人爬山速度，每爬完100米显示信息；爬到终点时给出相应提示
    public static void main(String[] args) {
        man youngman = new man();
        man oldman = new man();
        youngman.setName("年轻人");
        oldman.setName("老年人");
        youngman.start();
        oldman.start();
    }
}


class man extends Thread {
    //重写方法
    @Override
    public void run() {
        String str =Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.println(str+"爬了100米");
        }
        System.out.println(str+"爬完了");
    }
}
