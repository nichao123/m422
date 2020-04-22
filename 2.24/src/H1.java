public class H1 {
    public static void main(String[] args) {
        Running r=new Running();
        for(int i=0;i<10;i++){
            Thread th1=new Thread(r,(i+1)+"号选手");
            th1.start();
        }
    }
}
class Running implements Runnable{
    private int meter=1000;
    @Override
    public void run() {
        while (true){
            if (meter<=100){
                break;
            }
            paobu();
            return;
        }
    }
    synchronized void paobu(){
        System.out.println(Thread.currentThread().getName()+"拿到接力棒");
        for (int i = 0; i <100; i+=10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + (i + 10) + "米！");
        }
        meter-=100;
    }
}