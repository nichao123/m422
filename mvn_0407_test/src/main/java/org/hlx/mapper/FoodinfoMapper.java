package org.hlx.mapper;

import org.apache.ibatis.annotations.Param;
import org.hlx.pojo.Foodinfo;
import org.hlx.pojo.FoodinfoExample;

import java.util.List;

public interface FoodinfoMapper {
    long countByExample(FoodinfoExample example);

    int deleteByExample(FoodinfoExample example);

    int deleteByPrimaryKey(Integer foodid);

    int insert(Foodinfo record);

    int insertSelective(Foodinfo record);

    List<Foodinfo> selectByExample(FoodinfoExample example);

    Foodinfo selectByPrimaryKey(Integer foodid);

    int updateByExampleSelective(@Param("record") Foodinfo record, @Param("example") FoodinfoExample example);

    int updateByExample(@Param("record") Foodinfo record, @Param("example") FoodinfoExample example);

    int updateByPrimaryKeySelective(Foodinfo record);

    int updateByPrimaryKey(Foodinfo record);
}