package org.hlx.scope;

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
       ApplicationContext context =new ClassPathXmlApplicationContext("spring-cfg-score.xml");

//       4、从spring容器中把helloWorld取出来
         Hello hello1= (Hello) context.getBean("hello");

         Hello hello2= (Hello) context.getBean("hello");

       System.out.println(hello1);
       System.out.println(hello2);

    }

}
