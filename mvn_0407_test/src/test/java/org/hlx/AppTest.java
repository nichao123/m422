package org.hlx;

import org.apache.ibatis.session.SqlSession;
import org.hlx.mapper.UserinfoMapper;
import org.hlx.pojo.Userinfo;
import org.hlx.pojo.UserinfoExample;
import org.hlx.util.MybatisUtil;
import org.junit.Test;

import java.math.BigDecimal;
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
    public void all()
    {
        //1.会话对象
        SqlSession session = MybatisUtil.getSession();

        ////////////////////////
        //UserinfoMapper接口
        UserinfoMapper mapper=session.getMapper(UserinfoMapper.class);


        //创建对象//////////////////////////////
        UserinfoExample  example =new UserinfoExample();
        //获得Criteria对象
        UserinfoExample.Criteria criteria =example.createCriteria();
        //添加条件
        criteria.andRealnameLike("彭%");
        criteria.andUseridEqualTo(2);

        ///////////////////////////////////////////////
        //调用方法
        List<Userinfo>  list = mapper.selectByExample(example);

        for (Userinfo user:
                list ) {
            System.out.println(user);
        }

        //2.关闭会话
        MybatisUtil.closeSession(session);

    }


    @Test
    public void del()
    {
        //1.会话对象
        SqlSession session = MybatisUtil.getSession();

        ////////////////////////
        //UserinfoMapper接口
        UserinfoMapper mapper=session.getMapper(UserinfoMapper.class);

        //调用方法
         int count = mapper.deleteByPrimaryKey(22);

         System.out.println(count);

         //提交事务
        session.commit();


        //2.关闭会话
        MybatisUtil.closeSession(session);


    }


    @Test
    public void save()
    {
        //1.会话对象
        SqlSession session = MybatisUtil.getSession();

        ////////////////////////
        //UserinfoMapper接口
        UserinfoMapper mapper=session.getMapper(UserinfoMapper.class);


        //实体对象
        Userinfo user =new Userinfo();
        user.setLoginname("Anderson");
        user.setLoginpass("000");
        user.setAmount(new BigDecimal(100));
        user.setRealname("安东尼");

        //调用方法
        int count = mapper.insertSelective(user);

        System.out.println(count);

        //提交事务
        session.commit();


        //2.关闭会话
        MybatisUtil.closeSession(session);


    }


    @Test
    public void udpate()
    {
        //1.会话对象
        SqlSession session = MybatisUtil.getSession();

        ////////////////////////
        //UserinfoMapper接口
        UserinfoMapper mapper=session.getMapper(UserinfoMapper.class);


        //实体对象
        Userinfo user =new Userinfo();
        user.setLoginpass("111");
        user.setAmount(new BigDecimal(500));
        user.setRealname("安东尼亚");
        user.setPhone("110");
        //必须写IDPK
        user.setUserid(23);

        //调用方法
        int count = mapper.updateByPrimaryKeySelective(user);

        System.out.println(count);

        //提交事务
        session.commit();


        //2.关闭会话
        MybatisUtil.closeSession(session);


    }
}
