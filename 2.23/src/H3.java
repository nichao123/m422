public class H3 {
    public static void main(String[] args) {
        PaShang youngMan = new PaShang("年轻人",500,1);
        PaShang oldMan = new PaShang("老年人",1000,1);
        System.out.println("********开始爬山*********");
        youngMan.start();
        oldMan.start();
    }
}
class PaShang extends Thread{
    private int time;
    public int num = 0;

    public PaShang(String name, int time, int km) {
        super(name);
        this.time = time;
        this.num = km * 1000 / 100;
    }

    public void run() {
        while (num > 0) {
            try {
                Thread.sleep(this.time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "爬完100米！");
            num--;
        }
        System.out.println(Thread.currentThread().getName()+"到达终点！");
    }
}