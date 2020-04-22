import java.util.ArrayList;
import java.util.List;

public class H3 {
    public static void main(String[] args) {

        Runnable666 rb = new Runnable666();



        Thread th1=new Thread(rb,"抽奖箱1");
        th1.start();
        Thread th2=new Thread(rb,"抽奖箱2");
        th2.start();
    }

}
class Runnable666 implements Runnable{

    int[] arr = {600, 88, 20, 50, 100, 200, 500, 900, 5, 1000, 2000,60,300};
    List<Integer> list = new ArrayList<Integer>();

    @Override
    public void run() {
        while(true){
            synchronized (this) {
                int index = (int) (Math.random()*arr.length);
                if(list.size() == arr.length){
                    return;
                }
                if(!list.contains(index)){
                    list.add(index);

                    try {
                        Thread.sleep(1000);
                        String name = Thread.currentThread().getName();
                        if(name.equals("抽奖箱1")){
                            System.out.println(name+"又产生了一个 "+arr[index]+"元大奖");
                        }
                        if(name.equals("抽奖箱2")){
                            System.out.println(name+"又产生了一个 "+arr[index]+"元大奖");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
