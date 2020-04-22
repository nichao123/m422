package javaoop_0221.src.home.xcy;

public class Work2 {

//练习2：需求说明
//修改上机练习1，要求线程类使用实现Runnable接口的方式创建，并修改测试类
public static void main(String[] args) {
    //创建线程对象
    MyRunable my = new MyRunable();
    //线程代理
    Thread th =new Thread(my,"xcy");

    //启动子线程
    th.start();



}


}
class MyRunable implements  Runnable{
    //重写方法
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"实现Runnable接口的方式创建，并修改测试类");
    }
}