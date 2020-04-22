package javaoop_0225.src.home.hc;

public class Home1 {
    public static void main(String[] args) {
//        练习1：模拟接力赛跑
//                需求说明
//        多人参加1000米接力跑，每人跑100米，换下个选手；每跑10米显示信息
        Pao pao=new Pao();
        Thread t1=new Thread(pao,"一号选手");
        Thread t2=new Thread(pao,"二号选手");
        Thread t3=new Thread(pao,"三号选手");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Pao implements Runnable{
    private int count=0;
    @Override
    public void run() {
        paobu();
    }
    synchronized private void paobu(){
        System.out.println(Thread.currentThread().getName()+"拿到接力棒！");
        for(int i=0;i<10;i++){
            count+=10;
            System.out.println(Thread.currentThread().getName()+"跑了"+count+"米！");
            if(count==100){
                count=0;
            }
        }
    }
}