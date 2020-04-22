package org.hlx.life;

/**
 * @ClassName Hello
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/8
 * @Version V1.0
 **/
public class Hello {

    public Hello() {
        System.out.println("1.加载并实例化对象！");
    }

    public void init() {
        System.out.println("2.初始化！");
    }


    public void destroy() {
        System.out.println("4.火花！");
    }


    public void show(){
        System.out.println("3.处理数据");
    }
}
