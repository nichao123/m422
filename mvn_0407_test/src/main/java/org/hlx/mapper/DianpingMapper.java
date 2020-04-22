package org.hlx.mapper;

import org.apache.ibatis.annotations.Param;
import org.hlx.pojo.Dianping;
import org.hlx.pojo.DianpingExample;

import java.util.List;

public interface DianpingMapper {
    long countByExample(DianpingExample example);

    int deleteByExample(DianpingExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(Dianping record);

    int insertSelective(Dianping record);

    List<Dianping> selectByExample(DianpingExample example);

    Dianping selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") Dianping record, @Param("example") DianpingExample example);

    int updateByExample(@Param("record") Dianping record, @Param("example") DianpingExample example);

    int updateByPrimaryKeySelective(Dianping record);

    int updateByPrimaryKey(Dianping record);
}