package javaoop_0226.src.home.da.product;

class Storage {     //仓库类
    private String name;                          //产品名称
    private int max;
    private int num;    //最大库存量、产品库存数
    private int serialNum;  //产品编号(入仓号)
    int id;

    //
    public Storage(String name, int max) {
        this.name =name;
        this.max =max;

    }

    public synchronized void input() {    //同步的生产(入仓)方法
        while (num >= max) {               //若产品数超出最大库存量
            try {
                wait();
            } catch (Exception e) {
            }
        }      //则等待
        this.num++;                                //直到被通知唤醒才生产
        serialNum++;
        notify();       //通知消费
        System.out.println("生产编号" + serialNum + name + "，当前库存数：" + num);
    }


    public synchronized void output() {   //同步的消费(出仓)方法
        while (num <= 0) {                          //若库存没有产品
            try {
                wait();
            } catch (Exception e) {
            }
        }  //则等待
        this.num--;                                //直到被通知唤醒才消费

       // int id=serialNum;

        notify();                                   //通知生产
        System.out.println("消费编号" +(serialNum--)+ name + "，当前库存数：" + num);

    }

}