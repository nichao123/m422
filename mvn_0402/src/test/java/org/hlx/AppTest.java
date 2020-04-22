package org.hlx;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hlx.pojo.Userinfo;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void del() {
//       1.  读取核心配置文件mybatis-config.xml
        String cfg = "mybatis-cfg.xml";

        try {
            //输入流对象
            InputStream is = Resources.getResourceAsStream(cfg);

            // 2. 创建SqlSessionFactory对象，读取配置文件
            SqlSessionFactory  factory = new SqlSessionFactoryBuilder().build(is);

//       3. 创建SqlSession对象,自动关闭   false:开启事务
            try(SqlSession session = factory.openSession(false);){

                // 4. 调用mapper文件进行数据操作
                //封装参数
                int count = session.insert("org.hlx.dao.UserinfoMapper.del",16);

                //事务提交////
                session.commit();
                ///////////////

                System.out.println(count);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void save() {
//       1.  读取核心配置文件mybatis-config.xml
        String cfg = "mybatis-cfg.xml";

        try {
            //输入流对象
            InputStream is = Resources.getResourceAsStream(cfg);

            // 2. 创建SqlSessionFactory对象，读取配置文件
            SqlSessionFactory  factory = new SqlSessionFactoryBuilder().build(is);

//       3. 创建SqlSession对象,自动关闭   false:开启事务
            try(SqlSession session = factory.openSession(false);){

                // 4. 调用mapper文件进行数据操作
                //封装参数
                Userinfo user =new Userinfo("Shawn","000","110","肖恩",100);
                int count = session.insert("org.hlx.dao.UserinfoMapper.save",user);

                //事务提交////
                session.commit();
                ///////////////

                System.out.println(count);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void update() {
//       1.  读取核心配置文件mybatis-config.xml
        String cfg = "mybatis-cfg.xml";

        try {
            //输入流对象
            InputStream is = Resources.getResourceAsStream(cfg);

            // 2. 创建SqlSessionFactory对象，读取配置文件
            SqlSessionFactory  factory = new SqlSessionFactoryBuilder().build(is);

//       3. 创建SqlSession对象,自动关闭   false:开启事务
            try(SqlSession session = factory.openSession(false);){

                // 4. 调用mapper文件进行数据操作
                //封装参数
//                Userinfo user =new Userinfo(22,"Rachel","111","114","雷切尔",500,0);
                Userinfo user =new Userinfo("Rachel","111","114","雷切尔",500);
                int count = session.insert("org.hlx.dao.UserinfoMapper.update",user);

                //事务提交////
                session.commit();
                ///////////////

                System.out.println(count);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void find() {
//       1.  读取核心配置文件mybatis-config.xml
        String cfg = "mybatis-cfg.xml";

        try {
            //输入流对象
            InputStream is = Resources.getResourceAsStream(cfg);

            // 2. 创建SqlSessionFactory对象，读取配置文件
            SqlSessionFactory  factory = new SqlSessionFactoryBuilder().build(is);

//       3. 创建SqlSession对象,自动关闭
            try(SqlSession session = factory.openSession();){

                // 4. 调用mapper文件进行数据操作
                Userinfo userinfo = session.selectOne("org.hlx.dao.UserinfoMapper.selectUerinfo",20);
                System.out.println(userinfo);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void all() {
//       1.  读取核心配置文件mybatis-config.xml
        String cfg = "mybatis-cfg.xml";

        try {
            //输入流对象
            InputStream is = Resources.getResourceAsStream(cfg);

            // 2. 创建SqlSessionFactory对象，读取配置文件
            SqlSessionFactory  factory = new SqlSessionFactoryBuilder().build(is);

//       3. 创建SqlSession对象,自动关闭
            try(SqlSession session = factory.openSession();){

                // 4. 调用mapper文件进行数据操作
               List<Userinfo>  userinfos= session.selectList("org.hlx.dao.UserinfoMapper.all");
                for (Userinfo userinfo:
                        userinfos  ) {
                    System.out.println(userinfo);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
