package org.hlx.dao;

import org.hlx.entity.Subject;

import java.util.List;

public interface SubjectDao {

    //查询
    List<Subject> all(String name);

    //添加
    int addSubject(Subject subject);

    //修改
    int updateSubject(Subject subject);

    //删除
    int delSubject(int id);

   //获得一条信息
    Subject getSubject(int id);

}
