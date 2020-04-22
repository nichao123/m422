package org.nichao;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.nichao.mapper.SmbmsUserMapper;
import org.nichao.pojo.SmbmsUser;
import org.nichao.pojo.SmbmsUserExample;
import org.nichao.util.MybatisUtil;

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
        SmbmsUserMapper mapper=session.getMapper(SmbmsUserMapper.class);


        //创建对象//////////////////////////////
        SmbmsUserExample example =new SmbmsUserExample();
        //获得Criteria对象
        SmbmsUserExample.Criteria criteria =example.createCriteria();
        //添加条件


        ///////////////////////////////////////////////
        //调用方法
        List<SmbmsUser> list = mapper.selectByExample(example);

        for (SmbmsUser user:
                list ) {
            System.out.println(user);
        }

        //2.关闭会话
        MybatisUtil.closeSession(session);

    }
}
