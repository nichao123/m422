package org.hlx.hello2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestHello
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/8
 * @Version V1.0
 *
 * 说明：spring容器负责创建对象，程序员不用创建对象
 **/
public class TestHello {

   @Test
    public void test1(){
//       3、启动spring容器
       ApplicationContext context =new ClassPathXmlApplicationContext("spring-cfg.xml");

//       4、从spring容器中把helloWorld取出来
         Hello hello= (Hello) context.getBean("hello");

//       5、对象.方法
         hello.show();
    }

}
