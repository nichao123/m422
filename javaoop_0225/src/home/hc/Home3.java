package javaoop_0225.src.home.hc;

public class Home3 {
    public static void main(String[] args) {
//        上机1：抽奖池★★★☆☆
//        有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组
//        int[] arr ={600, 88, 20, 50, 100, 200, 500, 900, 5, 1000, 2000,60,300}
//        创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上,格式如下:
//        提示:通过随机数的下标int index = (int) (Math.random() * arr.length);
//        获得当前值int get = arr[index];
//        存放抽奖券是否抽过  boolean[] flag = new boolean[arr.length];
        Choujiang c=new Choujiang();
        Thread t1=new Thread(c,"抽奖箱1");
        Thread t2=new Thread(c,"抽奖箱2");
        t1.start();
        t2.start();
    }
}
class Choujiang implements Runnable{
    @Override
    public void run() {
        chou();
    }

    private int[] arr ={600,88,20,50,100,200,500,900,5,1000,2000,60,300};

    private int num=arr.length;

//    存放抽奖券是否抽过
    boolean[] flag = new boolean[arr.length];  //默认是false;

    //
    public void chou() {
      //  System.out.println(num);

        //循环
        while (true) {
            //判断
            if (num > 0) {
                //索引下标
                int index = (int) (Math.random() * arr.length);
                //
                boolean flag1 = flag[index];
                //
                if (!flag1) {
                    flag[index] = true;
                    int get = arr[index];
                    num--; //
                    System.out.println(Thread.currentThread().getName() + "产生了" + arr[index] + "元大奖");
                }
            } else {
                break;
            }
        }
    }
}