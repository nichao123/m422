package org.hlx.mapper;

import org.hlx.pojo.Class;

public interface ClassMapper {
    int insert(Class record);

    int insertSelective(Class record);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}