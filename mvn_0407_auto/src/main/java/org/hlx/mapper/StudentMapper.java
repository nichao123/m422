package org.hlx.mapper;

import org.hlx.pojo.Student;

public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}