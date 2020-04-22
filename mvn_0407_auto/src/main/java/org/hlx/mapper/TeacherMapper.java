package org.hlx.mapper;

import org.hlx.pojo.Teacher;

public interface TeacherMapper {
    int insert(Teacher record);

    int insertSelective(Teacher record);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}