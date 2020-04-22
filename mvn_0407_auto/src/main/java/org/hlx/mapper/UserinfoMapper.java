package org.hlx.mapper;

import org.hlx.pojo.Userinfo;

public interface UserinfoMapper {
    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}