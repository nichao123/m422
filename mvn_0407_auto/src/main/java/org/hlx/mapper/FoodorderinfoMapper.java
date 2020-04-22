package org.hlx.mapper;

import org.hlx.pojo.Foodorderinfo;

public interface FoodorderinfoMapper {
    int insert(Foodorderinfo record);

    int insertSelective(Foodorderinfo record);

    int updateByPrimaryKeySelective(Foodorderinfo record);

    int updateByPrimaryKey(Foodorderinfo record);
}