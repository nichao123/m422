package javaoop_0226.src.home.da.product;

class Producer extends Thread { //生产者类
    Storage store;

    public Producer(Storage store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            store.input();
        }  //调用同步生产方法
    }
}

class Consumer extends Thread {//消费者类
    Storage store;

    public Consumer(Storage store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            store.output();
        }  //调用同步消费方法
    }
}

class TestProducter {

    public static void main(String[] args) {
        Storage store = new Storage("电视机", 4);  //库存4电视机仓库
        Producer producer = new Producer(store);   //生产者
        Consumer consumer = new Consumer(store);   //消费者
        producer.start();
        consumer.start();
    }

}
