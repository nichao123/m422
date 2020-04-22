package org.hlx.extend;

import org.hlx.scope.Hello;
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
public class TestAnimal {

   @Test
    public void test1(){
//       3、启动spring容器
       ApplicationContext context =new ClassPathXmlApplicationContext("spring-cfg-extend.xml");

//       4、从spring容器中把helloWorld取出来
         Cat hello1= (Cat) context.getBean("cat");

         hello1.show();

    }

}
