package javaoop_0225.src.home.da.three;

/**
 * @NAME: Mythread
 * @AUTHOR: HLX
 * @CREATE: 2020/1/6 16:32
 * @PROJECT_NAME: javahight59
 **/
public class Mythread {
    public static void main(String[] args) {
        SelectRunnable sel = new SelectRunnable();
        //两个线程
        for (int i = 0; i < 2; i++) {
            new Thread(sel, "抽奖箱" + (i + 1)).start();
        }
        

    }
}

class SelectRunnable implements Runnable {
    //数组
    int[] arr = {600, 88, 20, 50, 100, 200, 500, 900, 5, 1000, 2000,60,300};
    //长度
    int num = arr.length;
    //存放标识
    boolean[] flag = new boolean[arr.length];

    //重写这个方法
    public void run() {

        while (true) {
            //同步块
            synchronized (this) {
                if (num <= 0) {
                    break;
                }
                //随机数的下标
                int index = (int) (Math.random() * arr.length);

                //获得值
                int get = arr[index];

                // 代表这张抽奖券抽过了
                if (!flag[index]) {

                    flag[index] = true;
                    System.out.println(Thread.currentThread().getName()
                            + " 又产生了一个" + get + "元大奖");
                    //数组的长度-1
                    num--;
                }
            }

        }
    }
}