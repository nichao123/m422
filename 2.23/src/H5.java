import java.util.ArrayList;

public class H5 {
    public static void main(String[] args) {

        RuChangThread ruChangThread;
        Thread qian;
        Thread hou;
        boolean isDoor=true;
        for (int i = 0; i < 100; i++) {
            int ID=(int)(Math.random()*100+1);
            ArrayList<Integer> lottery=new ArrayList<>();
            StringBuffer sBuffer=new StringBuffer("[");
            for (int j = 0; j < 7; j++) {
                lottery.add((int)(Math.random()*32));
                if (j!=7) {
                    sBuffer.append(lottery.get(j)+",");
                }else {
                    sBuffer.append(lottery.get(j));
                }
            }
            sBuffer.append("]");
            ruChangThread=new RuChangThread(ID, lottery.toString());
            qian=new Thread(ruChangThread,"前门");
            hou=new Thread(ruChangThread,"后门");
            if (isDoor) {
                qian.start();
            } else {
                hou.start();
            }
            isDoor=!isDoor;
        }

    }

}
 class RuChangThread implements Runnable {
    int ID;
    String lottery;

    public RuChangThread(int iD, String lottery) {
        super();
        ID = iD;
        this.lottery = lottery;
    }

    @Override
    public void run() {
        ruChang();
    }
    public synchronized void ruChang() {
        System.out.println("编号为："+ID+" 的员工 从"+Thread.currentThread().getName()+" 入场! 拿到的双色球彩票号码是: "+lottery);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

}
