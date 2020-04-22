package org.hlx.extend;

/**
 * @ClassName Animal
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/8
 * @Version V1.0
 **/
public abstract class Animal {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/**
 * 子类
 */
class Cat extends  Animal{
    public void show(){
        System.out.println("子类=>"+this.getName());
    }
}
