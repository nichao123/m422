public class H2 {
    public static void main(String[] args) {
        Buy b1 = new Buy("军人售票口");
        Buy b2 = new Buy("学生售票口");
        Buy b3 = new Buy("老年人售票口");
        Buy b4 = new Buy("网上售票口");
        b1.start();
        b2.start();
        b3.start();
        b4.start();


    }
}
class Buy extends Thread{
    private static int ticket=30;

    public Buy() {
    }

   public Buy(String name){
        super(name);
   }
   public void run(){
        while (ticket>0){
            synchronized (Buy.class){
                if (ticket>0){
                    System.out.println(super.getName()+"窗口---->车票号No."+ticket);
                    ticket--;
                }else {
                    System.out.println(super.getName()+"票已售罄！！!");
                }
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
   }
}
