package org.nichao;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.nichao.pojo.Foodinfo;
import org.nichao.pojo.Userinfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
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
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

//       3. 创建SqlSession对象,自动关闭   false:开启事务
            try(SqlSession session = factory.openSession(false);){

                // 4. 调用mapper文件进行数据操作
                //封装参数
                int count = session.insert("org.nichao.dao.UserinfoMapper.del",3);

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
                Foodinfo foodinfo =new Foodinfo(31,"炒青菜","青菜",666,"好吃","kkk");
                int count = session.insert("org.nichao.dao.UserinfoMapper.save",foodinfo);

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

                Foodinfo foodinfo =new Foodinfo(30,"炒青菜","青菜",666,"好吃","kkk");
                int count = session.insert("org.nichao.dao.UserinfoMapper.update",foodinfo);

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
                Foodinfo foodinfo = session.selectOne("org.nichao.dao.UserinfoMapper.selectFoodinfo",1);
                System.out.println(foodinfo);

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
                List<Foodinfo> foodinfos= session.selectList("org.nichao.dao.UserinfoMapper.all");
                for (Foodinfo foodinfo:
                        foodinfos  ) {
                    System.out.println(foodinfo);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
