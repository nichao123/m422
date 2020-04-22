package javaoop_0221.src.lesson.org.hlx;

/**
 * @ClassName TestSleep0
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/21
 * @Version V1.0
 **/
public class TestSleep0 {
    public static void main(String[] args) {
         MyTime my =new MyTime();
         my.getTime(5);
    }
}

class MyTime {
    public void getTime(int num){
        for (int i = 1; i <num ; i++) {
            System.out.println(i+"秒");
            try {
                //休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}