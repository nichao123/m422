package javaoop_0224.src.lesson.org.hlx;

/**
 * @ClassName TestMovie
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/24
 * @Version V1.0
 *
 *   共享资源： 电影 （创建类,生产，消费）
 *   生产者:  写 ,共享资源 (线程类)
 *   消费者： 读取 ,共享资源(线程类)
 **/
public class TestMovie {
    public static void main(String[] args) {
         //  //共享资源
         Movie movie =new Movie();

         //线程对象
        Player player=new Player(movie);
        Watch  watch =new Watch(movie);

        //线程代理
        Thread th1 =new Thread(player);
        Thread th2 =new Thread(watch);

        //启动线程
        th1.start();
        th2.start();
    }
}


class Movie{
    private String name;  //电影名称

    //标记: true:生产，消费者等待，生产者完毕后通知消费者;
    //标记: false:消费，生产者等待，消费者完毕后通知生产者;
    private boolean flag =true;

    /**
     * 生产
     * @param name
     */
    public synchronized  void play(String name){
          //判断
        if(!flag){
            try {
                wait(); //生产等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //生产
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("播放:"+name);

        //赋值
        this.name =name;

        //通知消费
        notify();

        //消费
        flag=false;

    }


    /**
     * 消费
     */
    public synchronized  void sale(){
        //生产者在等待
       if(flag){
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

       //消费
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("观看:"+name);

        //通知生产者
//        notify();
         notifyAll();

        //状态要改变
        flag=true;

    }


}

/**
 * 生产者
 */
class Player implements  Runnable{
    //共享资源
    private Movie movie;

    /**
     * 构造方法
     * @param movie
     */
    public Player(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
           //奇数偶数
            if(i%2==0){
                movie.play("愤怒的小鸟2");
            }else{
                movie.play("飞鸽特工队");
            }
        }
    }
}

/**
 * 消费者
 */
class Watch implements  Runnable{

    //共享资源
    private Movie movie;

    public Watch(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            movie.sale();   //销售
        }
    }
}