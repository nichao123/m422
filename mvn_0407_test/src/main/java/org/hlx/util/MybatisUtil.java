package org.hlx.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private static SqlSessionFactory factory;

    //静态块
    static {
        String rescourse = "mybatis-cfg.xml";
        //输入流
        try {
            InputStream is = Resources.getResourceAsStream(rescourse);

            //工厂对象
            factory = new SqlSessionFactoryBuilder().build(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获得会话对象
    public static SqlSession getSession() {
        //开始事物
        return factory.openSession(false);
    }


    //关闭会话对象
    public static void closeSession(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }

}
