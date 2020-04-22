package org.hlx.mapper;

import org.hlx.pojo.Dianping;

public interface DianpingMapper {
    int insert(Dianping record);

    int insertSelective(Dianping record);

    int updateByPrimaryKeySelective(Dianping record);

    int updateByPrimaryKey(Dianping record);
}