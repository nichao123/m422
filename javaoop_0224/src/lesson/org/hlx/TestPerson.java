package javaoop_0224.src.lesson.org.hlx;

/**
 * @ClassName TestPerson
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/24
 * @Version V1.0
 **/
public class TestPerson {

    public static void main(String[] args) {
        //具体对象
         final  Person  dyy =new Person("戴一阳");
         final  Person  xcy =new Person("徐晨阳");

         //线程1
         Thread t1=new Thread(new Runnable() {
             @Override
             public void run() {
                 //线程同步
               synchronized (dyy){
                   System.out.println("t1占有"+dyy.getName());
                   try {
                       Thread.sleep(1000); //1s
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("t1 试图占有"+xcy.getName());
                   System.out.println("等待.....");

                   //同步线程
                   synchronized (xcy){
                       System.out.println("做事情......");
                   }
               }

             }
         });


        //线程2
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                //线程同步
                synchronized (xcy){
                    System.out.println("t2占有"+xcy.getName());
                    try {
                        Thread.sleep(1000); //1s
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 试图占有"+dyy.getName());
                    System.out.println("等待.....");

                    //同步线程
                    synchronized (dyy){
                        System.out.println("做事情......");
                    }
                }
            }
        });
        //启动线程
        t1.start();
        t2.start();

    }
}

/**
 * 人类
 */
class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}