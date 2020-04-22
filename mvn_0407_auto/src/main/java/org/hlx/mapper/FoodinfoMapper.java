package org.hlx.mapper;

import org.hlx.pojo.Foodinfo;

public interface FoodinfoMapper {
    int insert(Foodinfo record);

    int insertSelective(Foodinfo record);

    int updateByPrimaryKeySelective(Foodinfo record);

    int updateByPrimaryKey(Foodinfo record);
}