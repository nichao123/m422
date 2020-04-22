public class H2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new CureThread());
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        //主线程模拟医院叫号
        for(int i=0;i<20;i++){
            System.out.println("普通号:"+(i+1)+"号病人在看病！");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if(i==9){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class CureThread implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("特需号："+(i+1)+"号病人在看病！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}